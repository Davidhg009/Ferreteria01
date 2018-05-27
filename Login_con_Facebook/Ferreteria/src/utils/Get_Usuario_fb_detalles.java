package utils;

import java.util.Arrays;

import com.restfb.DefaultFacebookClient;

import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;


import beans.UsuarioFacebook;

public class Get_Usuario_fb_detalles {

	public UsuarioFacebook Obtener_Datos_Perfil(String accesstoken) {
		
		UsuarioFacebook obj_perfil_usuario =new UsuarioFacebook(); 
	
		try {
			
		
		FacebookClient facebookClient=new DefaultFacebookClient(accesstoken,Version.VERSION_2_6);
		
		
		JsonObject fetchObjectsResults =
				  facebookClient.fetchObjects(Arrays.asList("me"), 
				           JsonObject.class, Parameter.with("fields","name,id,email,picture"));
		
		String temporal=fetchObjectsResults.toString();
		
		 obj_perfil_usuario.setNombre_usuario(temporal.substring(temporal.indexOf("\"name\":\"")+8, temporal.indexOf("\",\"id\":\"")));
		 obj_perfil_usuario.setId(temporal.substring(temporal.indexOf("\"id\":\"")+7, temporal.indexOf("\",\"email\":\"")));
		 obj_perfil_usuario.setEmail(temporal.substring(temporal.indexOf("\"email\":\""), temporal.indexOf("\",\"picture\":\"")));
		 obj_perfil_usuario.setPicture(temporal.substring(temporal.indexOf("\"url\":\"")+7, temporal.indexOf("\",\"width\":\"")));
	
		System.out.println(fetchObjectsResults);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  obj_perfil_usuario;
		
		}

}
