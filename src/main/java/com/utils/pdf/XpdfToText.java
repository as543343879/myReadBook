package com.utils.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * PDF转换txt测试类
 * @author jinhang
 *
 */
public class XpdfToText {
	// PDF文件名
	private File pdffile;
	// 转换器的存放位置
	private String CONVERTOR_STORED_PATH = "D:\\lucene\\xpdf\\bin32\\";
	// 转换器的名称，默认为pdftotext
	private String CONVERTOR_NAME = "pdftotext";

	// 构造函数，参数为pdf文件的路径
	public XpdfToText(String pdffile) throws IOException {
		this.pdffile = new File(pdffile);
	}

	// 将pdf转为文本文档，参数为目标文件的路径
	public void toTextFile(String targetfile) throws IOException {
		toTextFile(targetfile, true);
	}

	// 将pdf转为doc文档，参数为目标文件的路径,文件名称和原来名称相同
	public void toTextDocFile() throws Exception {
		if (pdffile != null && pdffile.length() > 0) {
			String targetfile = pdffile.getAbsolutePath();
			targetfile = targetfile.substring(0, targetfile.lastIndexOf(".")) + ".doc";
			toTextFile(targetfile, true);
		} else {
			throw new FileNotFoundException("没有可以转换的文件!");
		}
	}

	// 将pdf转为文本文档，参数为目标文件的路径，文件名称和原来名称相同
	public void toTextTxtFile() throws Exception {
		if (pdffile != null && pdffile.length() > 0) {
			String targetfile = pdffile.getAbsolutePath();
			targetfile = targetfile.substring(0, targetfile.lastIndexOf(".")) + ".txt";
			toTextFile(targetfile, true);
		} else {
			throw new FileNotFoundException("没有可以转换的文件!");
		}
	}

	// 将pdf转为文本文档，参数1为目标文件的路径，
	// 参数2为true则表示使用PDF文件中的布局
	public void toTextFile(String targetfile, boolean isLayout)
			throws IOException {
		String[] cmd = getCmd(new File(targetfile), isLayout);
		for (String cdms : cmd){
			System.out.println(cdms);
		}
		Runtime.getRuntime().exec(cmd);
	}

	// 获取PDF转换器的路径
	public String getCONVERTOR_STORED_PATH() {
		return CONVERTOR_STORED_PATH;
	}

	// 设置PDF转换器的路径
	public void setCONVERTOR_STORED_PATH(String path) {
		if (!path.trim().endsWith("\\"))
			path = path.trim() + "\\";
		this.CONVERTOR_STORED_PATH = path;
	}

	// 解析命令行参数
	private String[] getCmd(File targetfile, boolean isLayout) {

		// 命令字符
		String command = CONVERTOR_STORED_PATH + CONVERTOR_NAME;
		// PDF文件的绝对路径
		String source_absolutePath = pdffile.getAbsolutePath();
		// 输出文本文件的绝对路径
		String target_absolutePath = targetfile.getAbsolutePath();
		// 保持原来的layout
		String layout = "-layout";
		// 设置编码方式
		String encoding = "-enc";
		String character = "UTF-8"; //GBK或UTF-8
		// 设置不打印任何消息和错误
		String mistake = "-q";
		// 页面之间不加入分页
		String nopagebrk = "-nopgbrk";
		// 如果isLayout为false，则设置不保持原来的layout
		if (!isLayout)
			layout = "";
		return new String[] { command, layout, encoding, character, mistake,
				nopagebrk, source_absolutePath, target_absolutePath };
	}
	public static void main(String[] args) throws Exception {
		String fileName = "src/b.pdf";
        XpdfToText xpdfToText = new XpdfToText(fileName);  
        xpdfToText.toTextTxtFile();  
    }  
}