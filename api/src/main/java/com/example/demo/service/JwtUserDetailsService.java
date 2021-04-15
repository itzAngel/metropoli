package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agente;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	MetroService service;
	public boolean es = false;
	public User u;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Agente> lista = service.listarAgente();
		for(Agente a : lista) {
			if (a.getCorreo().equals(username)) {
				es=true;
				u =  new User(a.getCorreo(),a.getContrasena(),new ArrayList<>());
			}
		}
		if (es) {
			return u;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}