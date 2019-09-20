package com.java.web;

import java.io.BufferedReader;
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

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public void login(HttpServletRequest req, HttpServletResponse res) {
	
			try {
				String url = "https://kauth.kakao.com/oauth/authorize";
				url += "?client_id=5e45e7bcbf5c5c786829735f9be1f6ac&redirect_uri=";
				url += URLEncoder.encode("http://gdj16.gudi.kr:20008/KakaoLogin", "UTF-8");
				url += "&response_type=code";
				System.out.println("/login : " + url);
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
			String code = req.getParameter("code");
			System.out.println("code : " + code);
			String url = "https://kauth.kakao.com/oauth/token";
			url += "?client_id=5e45e7bcbf5c5c786829735f9be1f6ac&redirect_uri=";
			url += URLEncoder.encode("http://gdj16.gudi.kr:20008/KakaoLogin", "UTF-8");
			url += "&code=" + code;
			url += "&grant_type=authorization_code";
			System.out.println("/kakaoLogin : " + url);
			
			URL u = new URL(url);
			HttpURLConnection urlConnect = (HttpURLConnection) u.openConnection();
			urlConnect.setRequestMethod("POST");
			int resCode = urlConnect.getResponseCode();
			//System.out.println(resCode);
			//400 문법오류
			//500 네트워크 오류
			if(resCode == 200) {
				InputStream input = urlConnect.getInputStream();
				InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
				BufferedReader br = new BufferedReader(inputReader);
				String line = "";
				String result = "";
				while((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("result : " + result);
				
				JSONObject jObject = JSONObject.fromObject(result);
				String access_token = jObject.getString("access_token");
				System.out.println("access_token : " + access_token);
				
				String userUrl = "https://kapi.kakao.com/v2/user/me";
				userUrl += "?access_token=" + access_token;
				System.out.println("userUrl : " + userUrl);
				
				u = new URL(userUrl);
				urlConnect = (HttpURLConnection)u.openConnection();
				urlConnect.setRequestMethod("POST");
				resCode = urlConnect.getResponseCode();
				if(resCode == 200) {
					input = urlConnect.getInputStream();
					inputReader = new InputStreamReader(input, "UTF-8");
				    br = new BufferedReader(inputReader);
					line = "";
					result = "";
					while((line = br.readLine()) != null) {
						result += line;
					}
					System.out.println("userUrl result : " + result);
				}
				input.close();
			}
			res.sendRedirect("/");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
