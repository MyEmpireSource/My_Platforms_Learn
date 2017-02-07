package com.spring4.learn.poio.autowire;

/**
 * 
 * @Package: com.spring4.learn.poio.autowire
 * @ClassName: PersonForAutowire.java
 *
 * @Description: xml配置学习(applicationContexr_autowire.xml)
 * 				  配置自动装载 (id = "person9, person10, person11")
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年2月7日 下午2:11:23
 * @UpdateDate: 2017年2月7日 下午2:11:23
 * @Version: V1.0
 */
public class PersonForAutowire {
	
	private String name;
	
	private Address address;
	
	private CarForAutowire carForAutowire;

	public PersonForAutowire() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CarForAutowire getCarForAutowire() {
		return carForAutowire;
	}

	public void setCarForAutowire(CarForAutowire carForAutowire) {
		this.carForAutowire = carForAutowire;
	}

	@Override
	public String toString() {
		return "PersonForAutowire [name=" + name + ", address=" + address + ", car=" + carForAutowire + "]";
	}
	
}
