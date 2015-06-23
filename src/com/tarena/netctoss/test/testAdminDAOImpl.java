package com.tarena.netctoss.test;

import java.util.Arrays;

import junit.framework.TestCase;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.AdminRoleDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.dao.RolePrivilegeDAO;
import com.tarena.netctoss.dao.impl.AdminDAOImpl;

public class testAdminDAOImpl extends TestCase {
	public  void testAdminDAO() throws DAOException{
		AdminDAO dao = new AdminDAOImpl();
//		Admin admin = dao.findAdminByCodeAndPwd("admin", "111111");
//		admin.setAdminCode("老板娘");
//		admin.setRoles(new Integer[]{1,2,3});
//		dao.AdminAdd(admin);'
		System.out.println(dao.findAdminByCode("admin"));
//		CostDAO dao1 = new CostDAOImpl();
//		System.out.println(dao1.findAll());
//		List<Cost> costs = dao1.findCostByPage(1, 5);
//		System.out.println("1"+costs.size());
//		for(Cost cost : costs){
//			
//			System.out.println(cost.getId());
//		}
		//System.out.println(dao1.findCostPages(5));
//		System.out.println(dao1.findCostById(2).getName());
//		Cost cost = dao1.findCostById(2);
//		cost.setId(1002);
//		cost.setCreaTime(new java.sql.Date(new java.util.Date().getTime()));
//		System.out.println(dao1.saveCost(cost));
//		Cost cost=dao1.findCostByName("����");
//		cost.setDescr("���˵�");
//		System.out.println("����һ�ͳɹ�"+dao1.ModifyCost(cost));
	//	System.out.println((dao1.deleteById(2)>0)?"ɾ��ɹ�":"ɾ��ʧ��");
//		AccountDAO accountDAO = DAOFactory.getAccountDAO();
//		System.out.println(accountDAO.setStatus(0, 1010));
//		System.out.println(accountDAO.deleteAccountById(5));
//		Account account = accountDAO.findAccountByLoginName("dgbf70");
//		account.setLoginName("白3124的");
//		account.setIdcardNo("31224344");
//		account.setRecommenderId(null);
//		int a = accountDAO.saveAccount(account);
		//Account account = accountDAO.findAccountByIdcardNo("1234567890123456");
//		System.out.println(account.getIdcardNo());
//		account.setBirthDate(new java.sql.Date(System.currentTimeMillis()));
//		System.out.println(accountDAO.modifyAccount(account));
//		AccountDAOImpl dao2 = new AccountDAOImpl();
//		Map<String, String> map = accountDAO.getmustConditions();
//		Map<String,String> map2 = accountDAO.getlikeConditions();
//		//map.put("IDCARD_NO", "4");
//		//map.put("REAL_NAME", 1);
//		map2.put("IDCARD_NO", "4");
//		map2.put("REAL_NAME", "h");
////		String sql = dao2.createConditions(map, map2, 2);
////		System.out.println(sql);
//		System.out.println(":::"+accountDAO.findAccountByCondition(map, map2, 1,1).get(0).getRealName());
//		map.put("1", "123");
//		map.put("2", "ee");
//		Set<Entry<String,String>> set = map.entrySet();
//		for(Entry<String,String> entry : set){
//			System.out.println(entry.getKey());
//			entry.getValue();
//		}
//		String a = "23423542354365346435435454545454545";
//		
//		String b = a.replace("45", "1000");
//		System.out.println(b);
//		ServiceLineDAO serviceLineDAO = DAOFactory.getSerivceLineDAO();
//		ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
//		Service service1 = serviceDAO.findServiceByOsAndIp("huangr", "192.168.0.26");
//		service1.setCostId(37);
//		//System.out.println("serviceModify_result:"+serviceDAO.serviceModify(service1));
//		System.out.println(serviceDAO.ServiceDelete(49));
		
		//		Map<String,String> mustConditions = new LinkedHashMap<String,String>();
//		Map<String ,String> likeConditions = new LinkedHashMap<String,String>();
//		mustConditions.put(" OS_USERNAME ", "huangr");
//		mustConditions.put(" UNIX_HOST ", "");
//		likeConditions.put(" ACCOUNT_ID ", "10");
//		List<ServiceLine> services = serviceLineDAO.findServiceLineByConditions(mustConditions, likeConditions,1,5);
//		//System.out.println("totalpage:"+serviceLineDAO.getTotalPage(mustConditions, likeConditions, 5));
//		System.out.println(services.get(0).getCreateDate());
		//System.out.println(serviceLineDAO.findServiceLineById(2001).getCostName());
//		Service service = new Service();
//		service.setAccountId(1011);
//		service.setCostId(1);
//		service.setUnixHost("192.168.0.26");
//		service.setOsUsername("a");
//		service.setLoginPassWD("sdf");
//		List<
//		System.out.println(serviceDAO.serviceAdd(service));
//		HostDAO hostDAO = DAOFactory.getHostDAO();
//		System.out.println(hostDAO.findHostById("192.168.0.26").getLocation());
		RolePrivilegeDAO rolePrivilegeDAO = DAOFactory.getRolePrivilegeDAO();
//		System.out.println(Arrays.toString(rolePrivilegeDAO.findByRoleId(1)));
		RoleDAO roleDAO = DAOFactory.getRoleDAO();
		System.out.println(roleDAO.findAll());
//		System.out.println(roleDAO.findByPage(3,5).size());
////		System.out.println(roleDAO.getTotalPage(5));
//		int[] arr = new int[]{1,2,3};
////		System.out.println(arr.toString());
////		String a = "sdfsdf";
////		a.indexOf(ch)
//		List<String> list = new ArrayList<String>();
//		List<Integer> roleIds = rolePrivilegeDAO.findRolePrivilegeById(58);
//		System.out.println(roleIds);
//		System.out.println(Arrays.toString(rolePrivilegeDAO.findByRoleId(58)));
		//System.out.println(roleDAO.findById(58));
//		roleDAO.DeleteById(42);
		AdminDAO adminDAO = DAOFactory.getAdminDAO();
		//System.out.println(adminDAO.findAdmimListByConditions("2","大混子", 1, 5).size());
//		System.out.println(adminDAO.findAdmimListByConditions("2","BOSS", 1, 5));
		System.out.println(adminDAO.getTotalPage("2", "BOSS", 5));
//		AdminRoleDAO adminRoleDAO = DAOFactory.getAdminRoleDAO();
//		System.out.println(Arrays.toString(adminRoleDAO.findByAdminId(3)));

	}

}
