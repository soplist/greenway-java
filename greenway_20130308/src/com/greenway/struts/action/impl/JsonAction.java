package com.greenway.struts.action.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.greenway.pojo.impl.Note;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction  extends ActionSupport{
	private long results;
	public long getResults() {
		return results;
	}
	public void setResults(long results) {
		this.results = results;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	private List items;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String jsonExecute() throws Exception{
		/*
		this.results = 3;
		Note note_1 = new Note(1,"title1","context1");
		Note note_2 = new Note(2,"title2","context2");
		Note note_3 = new Note(3,"title3","context3");
		this.items = new ArrayList<Note>();
		this.items.add(note_1);
		this.items.add(note_2);
		this.items.add(note_3);
		return SUCCESS;*/
		List<Note> list = new ArrayList<Note>();
		for(int i=0;i<100;i++){
			Note note = new Note(i,"БъЬт"+i,"context"+i);
			list.add(note);
		}
		String json="{\"total\":\""+list.size()+"\",\"result\":[";
		for(int i = 0;i<list.size();i++){
			json+="{\"id\":\""+list.get(i).getId()+
					"\",\"title\":\""+list.get(i).getTitle()+
					"\",\"context\":\""+list.get(i).getContext()+"\"}";
			if (i != list.size() - 1) {
				json += ",";
			}
		}
		json += "]}";
		System.out.println("in:"+json);
		outputResult(json);
		/*
		List<Note> list;
		JSONArray json_array = new JSONArray();
		JSONObject json_obj = null;
		try{
			list = new ArrayList<Note>();
			Note note_1 = new Note(1,"title1","context1");
			Note note_2 = new Note(2,"title2","context2");
			Note note_3 = new Note(3,"title3","context3");
			list.add(note_1);
			list.add(note_2);
			list.add(note_3);
			
			Iterator i = list.iterator();
			while(i.hasNext()){
				json_obj = new JSONObject();
				Object[] obj = (Object[]) i.next();
				json_obj.put("id", obj[0]);
				json_obj.put("title", obj[1]);
				json_obj.put("context", obj[2]);
				json_array.add(json_obj);
			}
		}catch(Exception e){
			json_obj.put("success",false);
			json_obj.put("error",e.getMessage());
			return ERROR;
		}
		String allNoteWithJson = "{\"results\":" +list.size()+ ",\"rows\":";
		allNoteWithJson += json_obj.toString();
		allNoteWithJson += "}";
		System.out.println(allNoteWithJson);
		outputResult(allNoteWithJson);*/
		return null;
		
	}
	public void outputResult(String result) {   
        HttpServletResponse response = ServletActionContext.getResponse();   
        try {
        	response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(result);
        } catch (IOException e) {   
            // TODO Auto-generated catch block   
            e.printStackTrace();   
  
        }   
	}
}
