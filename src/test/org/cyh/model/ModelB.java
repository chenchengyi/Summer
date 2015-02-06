package test.org.cyh.model;

public class ModelB {

	ModelA modelA;
	ModelC modelC;
	
	public ModelB() {
		System.out.println("初始化modelB");
	}

	public void setModelC(ModelC modelC) {
		System.out.println("setModelB成功！");
		this.modelC = modelC;
	}

	public void setModelA(ModelA modelA) {
		System.out.println("setModelA成功!");
		this.modelA = modelA;
	}
	
	public ModelA getModelA() {
		return modelA;
	}

	
	public ModelC getModelC() {
		return modelC;
	}

	

}
