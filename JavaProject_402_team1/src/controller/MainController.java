package controller;

import java.util.HashMap;
import java.util.Map;

import print.Print;
import util.ScanUtil;
import util.View;


public class MainController extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();
	AdminController ac = new AdminController();
	MemberController mc = new MemberController();
	AttractionController atc = new AttractionController();
	TicketController tc = new TicketController();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case ADMIN:
				view = ac.admin();
				break;
			case ADMIN_LOGIN:
				view = ac.adLogin();
				break;
			case NOTICE:
				view = ac.notice();
				break;
			case NOTICE_LIST:
				view = ac.noticeList();
				break;
			case NOTICE_DETAIL:
				view = ac.noticeDetail();
				break;
			case NOTICE_INSERT:
				view = ac.noticeInsert();
				break;
			case NOTICE_DELETE:
				view = ac.noticeDelete();
				break;
			case NOTICE_UPDATE:
				view = ac.noticeUpdate();
				break;
			case ADTICKET:
				view = ac.ticket();
				break;
			case ADTICKET_LIST:
				view = ac.ticketList();
				break;
			case ADTICKET_INSERT:
				view = ac.ticketInsert();
				break;
			case ADTICKET_DELETE:
				view = ac.ticketDelete();
				break;
			case ADATT:
				view = ac.adAtt();
				break;
			case ADATT_LIST:
				view = ac.adattList();
				break;
			case ADATT_DETAIL:
				view = ac.adattDetail();
				break;
			case ADATT_INSERT:
				view = ac.adattInsert();
				break;
			case ADATT_UPADATE:
				view = ac.adattUpdate();
				break;
			case ADATT_DELETE:
				view = ac.adattDelete();
				break;
			case ADMEM:
				view = ac.admem();
				break;
			case ADMEM_LIST:
				view = ac.admemList();
				break;
			case ADMEM_DETAIL:
				view = ac.admemDetail();
				break;
			case ADMEM_UPDATE:
				view = ac.admemUpdate();
				break;
			case ADMEM_DELETE:
				view = ac.admemDelete();
				break;
			case ADSELL:
				view = ac.adsell();
				break;
			case ADSELL_MONTH:
				view = ac.adsellMonth();
				break;
			case ADSELL_DATE:
				view = ac.adsellDate();
				break;
				
			case MEMBER:
				view = mc.member();
				break;
			case MEM_DETAIL:
				view = mc.memDetail();
				break;
			case MEM_LOGIN:
				view = mc.memLogin();
				break;
			case MEM_UPDATE:
				view = mc.memUpdate();
				break;
			case MEM_OUT:
				view = mc.memOut();
				break;
			case BUYTICK_LIST:
				view = mc.buyTicketList();
				break; 
			case MEM_SIGNUP:
				view = mc.memSignup();
				break;
			case MEMNOTI:
				view = mc.memNoti();
				break;
			case MEMNOTI_DEATIL:
				view = mc.memNotiDetail();
				break;
			case ATT_LIST:
				view = atc.attList();
				break;
			case ATT_DETAIL:
				view = atc.attDetail();
				break;
			case TICKET_LIST:
				view = tc.ticketList();
				break;
			case BUY_TICKET:
				view = tc.buyTicket();
				break;
			default: 
				break;

			}
		}
	}
	
	
	private View home() {
		printLn(2);
		printStart();
		printhomeMenu();
		printLn(2);
		
		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		
		
		switch (sel) {
		case 1:
			return View.ADMIN_LOGIN;
		case 2:
			return View.MEMBER;
		case 3:
			return View.TICKET_LIST;
		case 4:
			return View.ATT_LIST;
		case 5:
			return View.MEMNOTI;
		default:
			printErr();
			return View.MAIN;
		}
	}
}
