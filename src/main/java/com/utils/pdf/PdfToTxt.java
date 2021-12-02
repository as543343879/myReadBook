package com.utils.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfToTxt {

	public static void main(String[] args) {
		try {
			//取得F盘下的pdf的内容
			readPdf("C:\\Users\\lizhi\\Downloads\\冷眼观爱2.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 传入一个.pdf文件
	 *
	 * @param file
	 * @throws Exception
	 */
	public static void readPdf(String file) throws Exception {
		// 是否排序
		boolean sort = false;
		// pdf文件名
		String pdfFile = file;
		// 输入文本文件名称
		String textFile = null;
		// 编码方式
		String encoding = "UTF-8";
		// 开始提取页数
		int startPage = 1;
		// 结束提取页数
		int endPage = Integer.MAX_VALUE;
		// 文件输入流，生成文本文件
		Writer output = null;
		// 内存中存储的PDF Document
		PDDocument document = null;
		try {
//			try {
//				// 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
//				URL url = new URL(pdfFile);
//				//注意参数已不是以前版本中的URL.而是File。
//				document = PDDocument.load(new File(pdfFile));
//				// 获取PDF的文件名
//				String fileName = url.getFile();
//				// 以原来PDF的名称来命名新产生的txt文件
//				if (fileName.length() > 4) {
//					File outputFile = new File(fileName.substring(0, fileName.length() - 4) + ".txt");
//					textFile = "F:/SJXLX/" + outputFile.getName();
//				}
//			} catch (MalformedURLException e) {
				// 如果作为URL装载得到异常则从文件系统装载
				//注意参数已不是以前版本中的URL.而是File。
			File file1 = new File(pdfFile);
			System.out.println(file1.getPath());
			document = PDDocument.load(file1);
				if (pdfFile.length() > 4) {
					textFile = pdfFile.substring(0, pdfFile.length() - 4) + ".txt";
				}
//			}
			// 文件输入流，写入文件倒textFile
			output = new OutputStreamWriter(new FileOutputStream(textFile), encoding);
			// PDFTextStripper来提取文本
			PDFTextStripper stripper = null;
			stripper = new PDFTextStripper();
			// 设置是否排序
			stripper.setSortByPosition(sort);
			// 设置起始页
			stripper.setStartPage(startPage);
			// 设置结束页
			stripper.setEndPage(endPage);
			// 调用PDFTextStripper的writeText提取并输出文本
			stripper.writeText(document, output);

			System.out.println(textFile + " 输出成功！");
		} finally {
			if (output != null) {
				// 关闭输出流
				output.close();
			}
			if (document != null) {
				// 关闭PDF Document
				document.close();
			}
		}
	}
}
