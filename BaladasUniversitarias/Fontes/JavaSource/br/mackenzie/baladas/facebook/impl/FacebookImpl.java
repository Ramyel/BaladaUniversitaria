package br.mackenzie.baladas.facebook.impl;

import java.util.List;

import br.mackenzie.baladas.facebook.Facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.Event;

public class FacebookImpl implements Facebook{
	private static final String ID_APP = "1410104595870928";
	private static final String SEGREDO_APP = "41a45d319476e327c0a0f2812b0c0594";
	
	FacebookClient conectorFb;
	
	public FacebookImpl(String token){
		AccessToken accessToken = new DefaultFacebookClient().obtainExtendedAccessToken(ID_APP, SEGREDO_APP, token);
		conectorFb = new DefaultFacebookClient(accessToken.getAccessToken());
	}
	
	public List<Event> obterEventos() {
		return this.conectorFb.fetchConnection("search", Event.class,  Parameter.with("type", "event"), Parameter.with("q", "universit�ria"), Parameter.with("timezone", "America/Sao_Paulo")).getData();
	}
}
