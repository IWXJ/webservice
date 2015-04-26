package dk.oneil;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Pizza {
	String name;
	String description;
	double price;
	
	public Pizza() {
	}
	
	public Pizza(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
