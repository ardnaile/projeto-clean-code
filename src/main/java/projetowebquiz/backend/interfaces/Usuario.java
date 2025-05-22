package projetowebquiz.backend.interfaces;

import org.bson.types.ObjectId;

public interface Usuario {
    ObjectId getId();
    String getUsuario();
    String getSenha();
}
