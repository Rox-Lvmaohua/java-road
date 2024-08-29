package org.capslv.trans;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

public class PDFMerger {

    /**
     * 合并多个PDF文件成一个PDF文件
     *
     * @param pdfFiles       要合并的PDF文件数组
     * @param outputFilePath 输出的PDF文件路径
     * @throws IOException 当文件操作失败时抛出异常
     */
    public static void mergePDFFiles(File[] pdfFiles, String outputFilePath) throws IOException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        
        // 添加每个PDF文件到合并列表中
        for (File file : pdfFiles) {
            pdfMerger.addSource(file);
        }
        
        // 设置输出文件的路径
        pdfMerger.setDestinationFileName(outputFilePath);
        
        // 合并文档
        pdfMerger.mergeDocuments(null);
    }

    public static void main(String[] args) {
        // 假设你有几个PDF文件需要合并
        File pdf1 = new File("path/to/first/document1.pdf");
        File pdf2 = new File("path/to/second/document2.pdf");
        File pdf3 = new File("path/to/third/document3.pdf");

        // 将这些文件放到数组中
        File[] pdfFiles = {pdf1, pdf2, pdf3};

        // 定义输出文件的路径
        String outputFilePath = "path/to/output/merged/document.pdf";

        try {
            // 合并PDF文件
            mergePDFFiles(pdfFiles, outputFilePath);
            System.out.println("合并完成，输出文件路径：" + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
