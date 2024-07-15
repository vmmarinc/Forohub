package com.alura.forohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forohub.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    UserDetails FindByCorreoElectronico();

    Usuario findByCorreoElectronico(String correoElectronico);

}
