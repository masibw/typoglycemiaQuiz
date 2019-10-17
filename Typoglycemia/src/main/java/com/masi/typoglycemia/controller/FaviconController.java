package com.masi.typoglycemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaviconController {
@RequestMapping("favicon.ico")
String favicon() {
	return "/favicon.ico";
}
}
