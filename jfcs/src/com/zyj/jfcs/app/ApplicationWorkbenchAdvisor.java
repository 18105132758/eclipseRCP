package com.zyj.jfcs.app;

import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.zyj.jfcs.app.model.Calcresult;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.zyj.jfcs.app.perspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    public void initialize(IWorkbenchConfigurer configurer) {
        super.initialize(configurer);
        //是否缓存窗口的状态，并在下次启动时还原，会拖慢启动速度。开发时不要开启此配置，影响功能测试
        configurer.setSaveAndRestore(false);	
        //是否使用传统标签样式
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, false);
        //启动时显示进度条
//        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_PROGRESS_ON_STARTUP, false);
        //显示欢迎画面
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_INTRO, true);
    }

    @Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public void postStartup() {
		super.postStartup();
		initJPASessionFactory();
		
	}

	/**
	 * 初始化JPA Session工厂
	 */
	private void initJPASessionFactory() {
		System.out.println("初始化Hibernate Session Factory！");
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			AppCache.sessionFactory = new MetadataSources(registry).buildMetadata(registry).buildSessionFactory();
			Session session = AppCache.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			AppCache.sessionFactory.openSession().beginTransaction();
			transaction.commit();
			Calcresult c = session.createQuery("from Calcresult where id = 1", Calcresult.class).uniqueResult();
			System.out.println(c);
			System.out.println("Hibernate Session Factory 初始化成功！");
			session.close();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}
	}

    
}
