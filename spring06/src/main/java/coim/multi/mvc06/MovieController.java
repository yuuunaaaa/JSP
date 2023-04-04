package coim.multi.mvc06;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //��Ʈ�ѷ��� ���, �̱��� ���� 
public class MovieController {

	@RequestMapping("movie")
	public void com(MovieVO vo, Model model) {
		System.out.println(vo);
		model.addAttribute("vo", vo);
	}
	@RequestMapping("fruit")
	public void fruit(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("���");
		list.add("����");
		list.add("����");
		list.add("����");
		model.addAttribute("list", list);
	}
	@RequestMapping("tour")
	public void tour(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("���ֵ�");
		list.add("�̱� ����");
		list.add("�̱� ����");
		list.add("ȫ��");
		list.add("��â");
		model.addAttribute("list", list);
	}
}