package com.ras.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author Rodrigo Arantes
 * Servlet que inicia o Log4J
 *
 */
@SuppressWarnings("serial")
public class Log4jInit extends HttpServlet {

	/** 
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {

		String realpath = getServletContext().getRealPath("/");
		realpath = substitui(realpath, "\\", "/");

		if (realpath != null && realpath.endsWith("/")) {
			realpath = realpath.substring(0, realpath.length() - 1);
		}
		//Obtem o Parametro inicial passado pela declaraçao do servlet no xml
		String logFile = "/" + getInitParameter("log4j-init-file");

		// CARREGANDO O ARQUIVO PROPERTIES DO LOG4J
		System.out.println("Iniciando o LOG4J ...");
		Properties p = new Properties();
		try {
			//transforma o arquivo de configuraçao do Log4J para InputStream em Java
			System.out.println("Property log4j: " + realpath + logFile);
			InputStream is = new FileInputStream(realpath + logFile);
			p.load(is);
			is.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("Não foi possível abrir o arquivo de configuração do log");
		} catch (IOException ioex) {
			System.out.println("Não foi possível carregar os parametros de configuração");
		}

		// ALTERANDO PASTA DO CAMINHO DO LOG
		p.setProperty("log4j.appender.RFA.File", realpath + "/ras.log");

		// CONFIGURANDO O LOG4J
		System.out.println("Carregando configuracao Log4J ...");
		PropertyConfigurator.configure(p);
		System.out.println("LOG4J INICIADO COM SUCESSO.");
	}

	
	/**
	 * Substitui uma String por outra
	 * @param origem
	 *            String original
	 * @param str1
	 *            String a ser substituída
	 * @param str2
	 *            String que será substituída
	 * @return String
	 */
	public static String substitui(String origem, String str1, String str2) {
		if (origem == null) {
			return "";
		}

		StringBuffer stb = new StringBuffer(origem.trim());
		String temp = stb.toString();

		int pos = temp.indexOf(str1);
		while (pos > -1) {
			stb.replace(pos, pos + str1.length(), str2);
			temp = stb.toString();
			pos = temp.indexOf(str1);
		}
		return stb.toString();
	}

}
