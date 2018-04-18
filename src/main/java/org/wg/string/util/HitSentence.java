package org.wg.string.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 提取命中句的类
 * @author 18170
 *
 */
public class HitSentence {
	/**
	 * 获得标红的命中句
	 * @param content
	 * @param keywords
	 * @return
	 */
	public static List<String>  getHitSentence(String content,List<String> keywords){
		List<String> rt = Collections.emptyList();
		if(StringUtils.isNotBlank(content)&&CollectionUtils.isNotEmpty(keywords)) {
			rt = new ArrayList<String>();
			List<String> splits = splitSentence(content,"[.。；;!！？?]");
			List<HitString> values = markedAndSort(keywords, splits);
			for(HitString hitString :values){
				rt.add(hitString.toString());
			}
		}
		return  rt;
	}
	/**
	 * 标红排序
	 * @param keywords
	 * @param splits
	 * @return
	 */
	private static List<HitString> markedAndSort(List<String> keywords, List<String> splits) {
		Pattern matchRegex =HitString.getRegex(keywords);
		HitString.setPrefixSuffer("", "");
		List<HitString> values = new ArrayList<HitString>();
		for(String spli:splits) {
			Matcher match = matchRegex.matcher(spli);
			if(match.find()) {
				values.add(new HitString(spli.trim(),keywords));
			}
		}
		Collections.sort(values);
		if(values.size()>4) {
			values = values.subList(0, 4);
		}
		return values;
	}
	/**
	 * 切分文章成句
	 * @param content
	 * @param pattern
	 * @return
	 */
	private static List<String> splitSentence(String content,String pattern) {
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(content);
		List<String>splits = new ArrayList<String>();
		int start =0;
		int end =0;
		while(matcher.find()) {
			end =matcher.end();
			splits.add(content.substring(start, end));
			start = end;
		}
		splits.add(content.substring(end));
		return splits;
	}
	public static void main(String[] args) {
		String content = "各位代表同志们: 值此中国国民党革命委员会第十三次全国代表大会隆重召开暨民革成立70周年之际中国共产党中央委员会谨向大会和民革成立70周年表示热烈的祝贺!向全体代表并通过你们向民革全体同志致以诚挚的问候和良好的祝愿! 自1948年1月成立以来中国国民党革命委员会已经走过70年的光荣历程。70年来民革继承和发扬孙中山先生爱国、革命和不断进步的精神始终致力于国家富强、民族复兴、人民幸福和促进祖国和平统一始终同中国共产党同心同德共经风雨、共谋发展、共创辉煌。在长期革命、建设、改革伟大实践中一代又一代的民革领导人团结带领广大成员矢志不渝同中国共产党亲密合作为多党合作事业不断发展、为国家繁荣富强贡献智慧和心血。实践充分证明民革作为中国共产党久经考验的亲密友党和中国特色社会主义参政党是中国从站起来、富起来到强起来伟大征程中的一支重要力量是决胜全面建成小康社会、夺取新时代中国特色社会主义伟大胜利的一支重要力量是实现中华民族伟大复兴中国梦的一支重要力量。 过去的5年是以习近平同志为核心的中共中央团结带领全国各族人民取得历史性成就的5年是党和国家事业发生历史性变革的5年。5年来民革围绕统筹推进“五位一体”总体布局、协调推进“四个全面”战略布局和促进祖国和平统一发挥了自身优势作出了重要贡献。坚持服务改革发展积极参加中国共产党领导的政治协商围绕全面依法治国、新型城镇化建设、“一带一路”建设等战略性全局性课题深入调查研究提出许多重要的意见和建议受到中共中央、国务院的高度重视。深入贯彻习近平总书记“两岸一家亲”理念着力打造“中山·黄埔·两岸情”等工作平台不断扩大与台湾各界的交往交流持续深化对台湾青年和基层民众工作为促进两岸关系和平发展作出了重要贡献。积极参与脱贫攻坚民主监督和社会服务工作坚持“寓监督于帮扶、寓帮扶于监督”持续参与毕节试验区建设动员全党力量精心打造“同心·博爱”系列品牌不断提高精准扶贫和社会服务实效。坚持把思想建设摆在突出位置深入开展坚持和发展中国特色社会主义学习实践活动不断推进组织建设和制度建设弘扬优良传统深化政治交接履职尽责的能力水平持续提升。在此谨向中国国民党革命委员会全体同志致以崇高的敬意! 中国共产党第十九次全国代表大会是在全面建成小康社会决胜阶段、中国特色社会主义进入新时代的关键时期召开的一次十分重要的大会。大会高举中国特色社会主义伟大旗帜确立了习近平新时代中国特色社会主义思想的历史地位作出了中国特色社会主义进入了新时代、我国社会主要矛盾已经转化为人民日益增长的美好生活需要和不平衡不充分的发展之间的矛盾等重大政治论断深刻阐述了新时代中国共产党的历史使命确定了决胜全面建成小康社会、开启全面建设社会主义现代化国家新征程的目标在中国共产党历史上、中华人民共和国历史上、中华民族历史上都具有重要的里程碑意义。 充分发挥统一战线的优势加强同各民主党派的团结合作是中国共产党的长期战略方针。中国共产党将按照中共十九大精神坚定不移坚持和完善中国共产党领导的多党合作和政治协商制度坚定不移贯彻长期共存、互相监督、肝胆相照、荣辱与共的方针坚定不移支持民主党派按照中国特色社会主义参政党要求更好履行职能把多党合作事业继续推向前进巩固和发展最广泛的爱国统一战线画出共同团结奋斗的最大同心圆。 决胜全面建成小康社会开启全面建设社会主义现代化国家新征程离不开包括民主党派和无党派人士在内的全国各族人民的共同奋斗。希望民革深入学习宣传贯彻中共十九大精神充分发挥自身特色和优势紧密结合参政议政重点领域围绕实施乡村振兴战略、深化依法治国实践、提高保障和改善民生水平、加强和创新社会治理等重大问题深入开展调查研究多献求真务实之策在新时代坚持和发展中国特色社会主义的新征程中续写新的辉煌篇章。 实现祖国完全统一是全体中华儿女共同愿望是中华民族根本利益所在。我们将继续坚持“和平统一、一国两制”方针坚持“九二共识”推动两岸关系和平发展推动两岸同胞共同反对一切分裂国家的活动共同为实现中华民族伟大复兴而奋斗。希望民革继续发挥与海内外联系广泛的优势进一步深化与岛内各阶层、各群体的联系交往推进两岸经济、文化、科技等方面的交流合作为实现祖国和平统一贡献力量。 中国国民党革命委员会第十三次全国代表大会是在中国特色社会主义进入新时代召开的一次重要会议。会议将总结成绩明确任务选举产生民革新一届中央领导机构。我们相信民革新一届中央领导机构一定能够团结带领广大成员继承和发扬老一辈的优良传统和高尚风范扎实推进政治交接更好地履行参政议政、民主监督、参加中国共产党领导的政治协商职能不断加强参政党建设努力开创民革工作新局面。 各位代表、同志们让我们更加紧密地团结在以习近平同志为核心的中共中央周围高举中国特色社会主义伟大旗帜以马克思列宁主义、毛泽东思想、邓小平理论、“三个代表”重要思想、科学发展观、习近平新时代中国特色社会主义思想为指导认真学习贯彻中共十九大精神不忘合作初心继续携手前进为决胜全面建成小康社会、夺取新时代中国特色社会主义伟大胜利、实现中华民族伟大复兴的中国梦继续奋斗! 祝中国国民党革命委员会第十三次全国代表大会圆满成功! 中国共产党中央委员会 2017年12月20日 (新华社北京12月20日电) ■新闻背景 中国国民党革命委员会 新华社北京12月20日电中国国民党革命委员会(简称“民革”)是具有政治联盟性质的、致力于建设中国特色社会主义和祖国统一事业的政党是中国共产党领导的多党合作和政治协商制度中的中国特色社会主义参政党。 1947年11月中国国民党民主派和其他爱国民主人士第一次联合会议在香港举行。1948年1月1日会议宣布中国国民党革命委员会正式成立。 民革成立以后参与了中国人民政治协商会议的筹备召开和中华人民共和国的创建为新中国的成立作出了重要贡献。 新中国成立后民革作为中国共产党领导的多党合作的成员参加人民政权和人民政协的工作为巩固人民民主专政、发展爱国统一战线、顺利实现社会主义改造和促进社会主义事业的发展发挥了积极的作用。 改革开放以来民革坚持中国共产党领导的多党合作和政治协商制度坚持走中国特色社会主义政治发展道路大力加强自身建设不断建立和健全参政议政、民主监督的工作机制在国家的改革开放建设和促进祖国和平统一的进程中发挥了重要作用。 中共十八大以来在以习近平同志为核心的中共中央领导下民革全党紧密围绕国家各项中心工作牢固树立政治意识、大局意识、核心意识、看齐意识不断增强中国特色社会主义道路自信、理论自信、制度自信、文化自信不断提高政治把握能力、参政议政能力、组织领导能力、合作共事能力和解决自身问题能力积极发挥自身特点和优势全面履行参政党职能各项工作开创了新局面。始终以孙中山爱国、革命、不断进步的精神鞭策和激励自己是民革的光荣传统。 民革历任主席为李济深、何香凝、朱蕴山、王昆仑、屈武、朱学范、李沛瑶、何鲁丽、周铁农。现任主席万鄂湘。 目前民革在全国共有30个省级委员会、274个市级委员会、51个县级委员会现有民革党员127930人。";
		List<String> rt = getHitSentence(content,Arrays.asList("习近平","孙中山"));
		System.out.println(rt);
//		String replaceAll = "习近平，孙中山".replaceAll("(孙中山|习近平)", "aaa");
//		System.out.println(replaceAll);
	}
	/**
	 * 关键句辅助类
	 * @author 18170
	 *
	 */
	private static class HitString implements Comparable<HitString>{
		/**
		 * 查询的关键字
		 */
		private  List<String> keywords;
		/**
		 * 替换的后缀
		 * 
		 */
		private static String suffer="</font>";
		/**
		 * 替换前缀
		 */
		private static String prefix = "<font style='color:red'>";
		/**
		 * 出现的关键字频率
		 */
		private int count;
		
		private String sentence ; 
		
		public static  void   setPrefixSuffer(String prefix,String suffer) {
			HitString.suffer = suffer;
			HitString.prefix=prefix;
		}
		
		
		public HitString(String sentence,List<String> keywords) {
			StringBuffer sb  = new StringBuffer();
			Matcher matcher = getRegex(keywords).matcher(sentence);
			while(matcher.find()) {
				count ++;
				matcher.appendReplacement(sb, prefix+matcher.group()+suffer);
			}
			matcher.appendTail(sb);
			this.sentence = sb.toString();
		
		}
		
		
		public int getCount() {
			return count;
		}
		public String getSentence() {
			return sentence;
		}
		@Override
		public String toString() {
			return this.sentence;
		}
		/**
		 * 重写排序规则
		 */
		@Override
		public int compareTo(HitString o) {
			int rt = 0;
			rt = o.getCount() - this.count;//先按词频重大到小排序
			if(rt == 0) {
				rt = this.sentence.length()-o.getSentence().length();//后按语句长度重小到大排序
			}
			return rt;
		}
		
		
		public static Pattern getRegex(List<String> keywords) {
			String regex = "(";
			for(String keyword :keywords) {
				regex+=keyword+"|";
			}
			regex = regex.substring(0, regex.length()-1);
			regex+=")";
			return Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		}
		
		
	}

}
