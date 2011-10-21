package com.jm.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class EmulateData {
	private static List<Magazine> magazines = Collections.synchronizedList(new ArrayList<Magazine>());
	private static List<Article> articles = Collections.synchronizedList(new ArrayList<Article>());
	
	static {
		/* 96 */
		Magazine m = new Magazine();
		m.setNumber(96);
		m.setName("Java Magazine");
		m.setPublisher("DevMedia");
		m.setCreated(new Date(2011, 10, 1));

		String[] articleTitles = { "jQuery UI na prática", "Além da IDE – Parte 4", "VRaptor 3 – Parte 3", "Inversão de Controle – Parte 2", "Dissecando a Java Collections", "Nem parece Web: é Vaadin!", "Acessibilidade em Java", "A importância dos Padrões de Projeto" };
		
		Article[] as = new Article[articleTitles.length];
		for (int idx = 0; idx < articleTitles.length; idx++) {
			as[idx] = new Article();
			as[idx].setTitle(articleTitles[idx]);
		}
		m.setArticles(as);
		articles.addAll(Arrays.asList(as));
		magazines.add(m);

		/* 95 */
		m = new Magazine();
		m.setNumber(95);
		m.setName("Java Magazine");
		m.setPublisher("DevMedia");
		m.setCreated(new Date(2011, 9, 1));
		
		articleTitles = new String[]{ "Distribuição de Dados com Java", "Java 7 – Aperfeiçoando o Java", "Jython", "JSF com Prevayler", "Spring Security 3, JSF 2 e JPA 2", "Seam 3: complementando a lógica com Weld", "Inversão de Controle – Parte 1", "Nem parece Web: é Vaadin! - Parte 1 (Exclusivo)" };
		as = new Article[articleTitles.length];
		for (int idx = 0; idx < articleTitles.length; idx++) {
			as[idx] = new Article();
			as[idx].setTitle(articleTitles[idx]);
		}
		m.setArticles(as);
		articles.addAll(Arrays.asList(as));
		magazines.add(m);

		/* 94 */
		m = new Magazine();
		m.setNumber(94);
		m.setName("Java Magazine");
		m.setPublisher("DevMedia");
		m.setCreated(new Date(2011, 8, 1));
		
		articleTitles = new String[]{ "Compilação Dinâmica no Java 6", "Seam 3: Weld, a base do novo framework", "Sensores no Android", "VRaptor 3 – Parte 2", "Além da IDE – Parte 3", "Model Driven Architecture", "Gestão de Defeitos no Teste de Software" };
		as = new Article[articleTitles.length];
		for (int idx = 0; idx < articleTitles.length; idx++) {
			as[idx] = new Article();
			as[idx].setTitle(articleTitles[idx]);
		}
		m.setArticles(as);
		articles.addAll(Arrays.asList(as));
		magazines.add(m);

		/* 93 */
		m = new Magazine();
		m.setNumber(93);
		m.setName("Java Magazine");
		m.setPublisher("DevMedia");
		m.setCreated(new Date(2011, 7, 1));
		
		articleTitles = new String[]{ "Além da IDE – Parte 2", "JBoss Application Server 6", "Interagindo com Aplicações Telecom", "Por dentro do PrimeFaces 2.2", "VRaptor 3 – Parte 1", "Primeiros passos com o Spring Integration", "Aspectos com Padrões de Segurança" };
		as = new Article[articleTitles.length];
		for (int idx = 0; idx < articleTitles.length; idx++) {
			as[idx] = new Article();
			as[idx].setTitle(articleTitles[idx]);
		}
		m.setArticles(as);
		articles.addAll(Arrays.asList(as));
		magazines.add(m);
	}

	public static List<Magazine> getMagazines() {
		return magazines;
	}

	public static List<Article> getArticles() {
		return articles;
	}
}
