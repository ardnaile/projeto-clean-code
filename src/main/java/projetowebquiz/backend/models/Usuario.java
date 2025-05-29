package projetowebquiz.backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public abstract class Usuario {
    @MongoId
    ObjectId id;
    String usuario;
    String senha;

    public ObjectId getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha(){
        return senha;
    }
}
