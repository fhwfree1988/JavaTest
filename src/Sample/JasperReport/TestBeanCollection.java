package Sample.JasperReport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestBeanCollection implements Serializable {

	/*private static final long serialVersionUID = 1L;

	private List<ConfirmNumberingEntity> collectionBean;

	public TestBeanCollection() {

	}

	public List<ConfirmNumberingEntity> getCollectionBean() {
		return collectionBean;
	}

	public void setCollectionBean(List<ConfirmNumberingEntity> collectionBean) {
		this.collectionBean = collectionBean;
	}

	public static Collection<ConfirmNumberingEntity> createBeanCollection() {
		*//*List<ConfirmNumberingEntity> collection = new ArrayList<>();
		collection.add(new ConfirmNumberingEntity("Hasan1", generateChild()));
		collection.add(new ConfirmNumberingEntity("Hasan2", generateChild()));
		collection.add(new ConfirmNumberingEntity("Hasan3", generateChild()));
		return collection;*//*
		List<ConfirmNumberingEntity> collection = new ArrayList<>();
		ConfirmNumberingEntity confirmNumberingEntity = new ConfirmNumberingEntity();
		confirmNumberingEntity.setId(12345L);
		collection.add(confirmNumberingEntity);

		return collection;
	}
*/
	/*private static List<ChildBean> generateChild() {
		List<ChildBean> childs = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			childs.add(new ChildBean("Pedar", "Khan", "Name"));
		}
		return childs;
	}*/

}
