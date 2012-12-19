package fr.pc00.model;

import java.util.ArrayList;

import fr.pc00.implement.Product;
import fr.pc00.model.state.EClientState;
import fr.pc00.model.utils.ProductQuantity;

public abstract class AbstractShop extends AbstractEntertainment {

	private ArrayList<ProductQuantity>	_products;
		
	public AbstractShop(String name)
	{
		super(name, EClientState.VISIT_SHOP, EEntertainmentType.SHOP);
		this._products = new ArrayList<ProductQuantity>();
	}
	
	public String toString()
	{
		String str = new String();
		StringBuffer sb = new StringBuffer();
		
		str = "Boutique :\n\tName : " + this._name +
				"Produits :";
		
		for (int i = 0; i < this._products.size(); ++i)
		{
			Product product = this._products.get(i).getProduct();
			sb.append("\n\t\t-" + product.getName() + " (" + product.getPrice() + ")");
		}
		str += sb.toString();

		return str;
	}
	
	public void addProduct(ProductQuantity product)
	{
		this._products.add(product);
	}
	
	public String getName() { return (this._name); }
	public ArrayList<ProductQuantity> getProducts() { return (this._products); }
	
	public void setNom(String name) { this._name = name; }
	public void setProducts(ArrayList<ProductQuantity> produits) { this._products = produits; }
}
