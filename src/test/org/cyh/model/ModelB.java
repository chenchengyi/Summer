package test.org.cyh.model;

public class ModelB {

	ModelA modelA;
	ModelC modelC;
	
	public ModelB() {
		System.out.println("��ʼ��modelB");
	}

	public void setModelC(ModelC modelC) {
		System.out.println("setModelB�ɹ���");
		this.modelC = modelC;
	}

	public void setModelA(ModelA modelA) {
		System.out.println("setModelA�ɹ�!");
		this.modelA = modelA;
	}
	
	public ModelA getModelA() {
		return modelA;
	}

	
	public ModelC getModelC() {
		return modelC;
	}

	

}
