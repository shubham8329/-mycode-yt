package com.jspiders.AdapterPattern.adapter;
import com.jspiders.AdapterPattern.Interfaces.Mock;
import com.jspiders.AdaptterPattern.object.Wejm4;
import com.jspiders.AdapterDesignPattern.adapter;

public class Adapter extends Wejm4 implements Mock {
		public static void main(String[] args) {
			adapter.rating();
		}
]
		
	public void rating() {
	adapter.setID(1);
	adapter.setName("Akshay");
	adapter.setTech_rating("1");
	adapter.setComm_rating("1");
}
 		System.out.println(adapter.getName()
		 +"has technical rating as:"
		 +adapter.getTech_rating()
		 +"and communication rating as:"
		 +adapter.getComm_rating());
 		
 }
 