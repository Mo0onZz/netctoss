package com.tarena.netctoss.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.tarena.netctoss.util.VerifyCodeUtil;

public class CheckCode extends BaseAction{
	private boolean ok = false;
	private String code;
	private InputStream codeInputStream;
	public  String createCode() throws Exception{
		VerifyCodeUtil vcu = new VerifyCodeUtil();
		vcu.generate(80, 30, 4);
		code = vcu.getCode();
		codeInputStream = new ByteArrayInputStream(vcu.getCodeArr());
		System.out.println(code);
		session.put(VERIFYCODE_KEY, code);
		return "success";
	}
	public String verifyCode(){
		String code1 = (String) session.get(VERIFYCODE_KEY);
		System.out.println(code1+","+code);
		if(code1.equals(code)){
			ok = true;
		}
		return "success";
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public InputStream getCodeInputStream() {
		return codeInputStream;
	}
	public void setCodeInputStream(InputStream codeInputStream) {
		this.codeInputStream = codeInputStream;
	}

}
