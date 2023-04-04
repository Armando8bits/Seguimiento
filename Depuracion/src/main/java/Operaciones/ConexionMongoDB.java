package Operaciones;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * @author ROQUEARMANDORAMIREZP
 */
public class ConexionMongoDB {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ConexionMongoDB() {
        String Credenciales = "aqui pones el link con tu usuario y contraseña";
        MongoClientURI uri = new MongoClientURI(Credenciales);
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("DBDepuracion");
        collection = database.getCollection("Fichas");
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoCursor<Document> getIteradorByID(String StrId) {
        return collection.find(eq("_id", new ObjectId(StrId))).iterator();
    }

    public void insertarDocumento(Document documento) {
        collection.insertOne(documento);
    }

    public void actualizarDocumento(Document filtro, Document datos) {
        collection.updateOne(filtro, new Document("$set", datos));
    }

    public void actualizarDocumento(String StrId, Document datos) {
        collection.updateOne(eq("_id", new ObjectId(StrId)), new Document("$set", datos));
    }

    public void actualizaDocumentos(String StrCampo, String StrParametro, Document nuevosValores) {
        //este metodo actualiza varos archivos, en funcion del parametro que le envies
        BasicDBObject consulta = new BasicDBObject();
        consulta.append(StrCampo, new ObjectId(StrParametro));
        collection.updateMany(consulta, new Document("$set", nuevosValores));
    }

    public void eliminarDocumento(Document filtro) {
        collection.deleteOne(filtro);
    }

    public void eliminarDocumento(String idArchivo) {
        BasicDBObject consulta = new BasicDBObject();
        consulta.append("_id", new ObjectId(idArchivo));
        collection.deleteOne(consulta);
    }

    public Document obtenerDocumento(Document filtro) {
        return collection.find(filtro).first();
    }

    public List<Document> obtenerDatos() {
        //este metodo obtiene todos los datos, todos los campos
        List<Document> documentos = new ArrayList<>();
        // Realizar consulta a la base de datos
        documentos = collection.find().into(new ArrayList<Document>());
        return documentos;
    }

    public Document obtenerArchivoPorId(String idArchivo) {
        Document document = collection.find(eq("_id", new ObjectId(idArchivo))).first();
        return document;
    }

    public List<Document> consulta(List<String> camposFiltrar, List<String> valoresFiltrar, List<String> camposMostrar, List<String> camposOrdenar) {
        List<Document> documentos = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();

        // Agregar filtros a la consulta
        for (int i = 0; i < camposFiltrar.size(); i++) {
            query.append(camposFiltrar.get(i), valoresFiltrar.get(i));
        }

        // Definir proyección
        BasicDBObject projection = new BasicDBObject();
        for (String campo : camposMostrar) {
            projection.append(campo, 1);
        }

        // Definir orden
        BasicDBObject order = new BasicDBObject();
        for (String campo : camposOrdenar) {
            order.append(campo, 1);
        }

        // Realizar consulta a la base de datos
        documentos = collection.find(query).projection(projection).sort(order).into(new ArrayList<Document>());

        return documentos;
    }

    public Boolean AnexaDocEnDoc(String idArchivo, Document visita) {
        //sirve para guardar un array en un campo sin borrar los anteriores
        Boolean rpta = false;;
        // Inserta un objeto tipo Array en el campo "vis"
        Bson update = Updates.push("vis", visita);

        // Actualizar el documento en la colección
        UpdateResult result = collection.updateOne(eq("_id", new ObjectId(idArchivo)), update);

        // Verificar si se actualizó correctamente
        if (result.getModifiedCount() == 1) {
            //System.out.println("\nLa visita se agregó correctamente.");
            rpta = true;
        }
        return rpta;
    }

    public void NuevoSeguimiento(String idArchivo, String StrFecha, String StrCom, String StrEst) {
        Boolean rpta = false;;
        
        List<Document> visitas = new ArrayList<Document>(); 
        Document visita1 = new Document("fev", StrFecha).append("com", StrCom);
        visitas.add(visita1);
        
        // Crear el documento con los nuevos elementos en "vis"
        Document nuevasVisitas = new Document("$push", new Document("vis", new Document("$each", visitas)));
        
        // Actualizar el valor del campo "est"
        Document nuevoEst = new Document("$set", new Document("est", StrEst));
        
            // Combinar los documentos de actualización en uno solo
    Document actualizacion = new Document();
    actualizacion.putAll(nuevasVisitas);
    actualizacion.putAll(nuevoEst);
    
        // Ejecutar la actualización en la colección
    collection.updateOne(eq("_id", new ObjectId(idArchivo)), actualizacion);
        
 
    }

    public void cierraSesion() {
        mongoClient.close(); // Cerrar la conexión
    }

}
