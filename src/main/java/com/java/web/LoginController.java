package com.java.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public void login(HttpServletRequest req, HttpServletResponse res) {
	
			try {
				String url = "https://kauth.kakao.com/oauth/authorize";
				url += "?client_id=5e45e7bcbf5c5c786829735f9be1f6ac&redirect_uri=";
				url += URLEncoder.encode("http://localhost:8080/KakaoLogin", "UTF-8");
				url += "&response_type=code";
				System.out.println(url);
				res.sendRedirect(url);
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	@RequestMapping("/KakaoLogin")
	public void kakao(HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println("KakaoLogin");
			String code = req.getParameter("code");
			System.out.println(code);
			String url = "https://kauth.kakao.com/oauth/token";
			url += "?client_id=5e45e7bcbf5c5c786829735f9be1f6ac&redirect_uri=";
			url += URLEncoder.encode("http://localhost:8080/KakaoLogin", "UTF-8");
			url += "&code" + code;
			url += "&grant_type=authorization_code";
			System.out.println(url);
			
			URL u = new URL(url);
			HttpURLConnection urlConnect = (HttpURLConnection)u.openConnection();
			urlConnect.setRequestMethod("POST");
			int resCode = urlConnect.getResponseCode();
			if(resCode == 200) {
				InputStream input = urlConnect.getInputStream();
				InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
				
			}
			
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
