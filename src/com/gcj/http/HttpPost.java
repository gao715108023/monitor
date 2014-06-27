package com.gcj.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gcj.common.Base64Util;

public class HttpPost implements Runnable {

    private String processId;

    private String tokenId;

    private String versionCode;

    private String msgId;

    public HttpPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HttpPost(String processId, String tokenId, String versionCode, String msgId) {
        super();
        this.processId = processId;
        this.tokenId = tokenId;
        this.versionCode = versionCode;
        this.msgId = msgId;
    }

    public List<String> readFile(String filePath) {
        List<String> msglist = new ArrayList<String>();
        FileInputStream fin = null;
        BufferedReader inn = null;
        try {
            fin = new FileInputStream(filePath);
            inn = new BufferedReader(new InputStreamReader(fin, "gb2312"));
            String line;
            StringBuffer sb = new StringBuffer();
            int count = 0;
            while ((line = inn.readLine()) != null) {
                String[] urlarr = line.split("	");
                if (urlarr == null || urlarr.length < 3)
                    continue;
                // String dt = String.format("%1$s%2$02d%3$02d%4$02d",
                // urlarr[0], 24, 60, 60);
                // System.out.println("TxtContent: " + dt);
                sb.append("\"" + urlarr[0] + "\",\"" + urlarr[1] + "\",\"" + urlarr[2] + "\"\n");
                // System.out.println("rule: " + sb.toString());
                count++;
                if (count >= 50) {
                    String msg = packMsg(sb.toString().getBytes("gb2312"));
                    msglist.add(msg);
                    // byte[] dataArr = sb.toString().getBytes("gb2312");
                    // AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
                    // byte[] enc = aes.encrypt(dataArr);
                    // String str = Base64Util.byteArrayToBase64(enc);
                    // byte[] uncArr = Base64Util.base64ToByteArray(str);
                    // byte[] decArr = aes.decrypt(uncArr);// 解密
                    // System.err.println(new String(decArr, "gb2312"));
                    // ByteString value = ByteString.copyFrom(enc);
                    sb.delete(0, sb.length());
                    count = 0;
                }
            }
            if (sb.length() > 0) {
                String msg = packMsg(sb.toString().getBytes("gb2312"));
                msglist.add(msg);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inn != null)
                    inn.close();
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return msglist;
    }

    public List<String> readFile(String filePath, int flag) {
        List<String> msglist = new ArrayList<String>();
        FileInputStream fin = null;
        BufferedReader inn = null;
        try {
            fin = new FileInputStream(filePath);
            inn = new BufferedReader(new InputStreamReader(fin, "gb2312"));
            String line;
            StringBuffer sb = new StringBuffer();
            // int count = 0;
            while ((line = inn.readLine()) != null) {
                String[] urlarr = line.split(":;");
                if (urlarr == null || urlarr.length < 2)
                    continue;
                String dt = String.format("%1$s%2$02d%3$02d%4$02d", "20130819", 16, 41, 00);
                // System.out.println("TxtContent: " + dt);
                sb.append("\"" + dt + "\",\"" + urlarr[0] + "\",\"" + urlarr[1] + "\"\n");
                // System.out.println("rule: " + sb.toString());
                // count++;
                String msg = packMsg(sb.toString().getBytes("gb2312"));
                msglist.add(msg);
                sb.delete(0, sb.length());
                // if (count >= 50) {
                // String msg = packMsg(sb.toString().getBytes("gb2312"));
                // msglist.add(msg);
                // // byte[] dataArr = sb.toString().getBytes("gb2312");
                // // AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
                // // byte[] enc = aes.encrypt(dataArr);
                // // String str = Base64Util.byteArrayToBase64(enc);
                // // byte[] uncArr = Base64Util.base64ToByteArray(str);
                // // byte[] decArr = aes.decrypt(uncArr);// 解密
                // // System.err.println(new String(decArr, "gb2312"));
                // // ByteString value = ByteString.copyFrom(enc);
                // sb.delete(0, sb.length());
                // count = 0;
                // }
            }
            // if (sb.length() > 0) {
            // String msg = packMsg(sb.toString().getBytes("gb2312"));
            // msglist.add(msg);
            // }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inn != null)
                    inn.close();
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return msglist;
    }

    public void testResult() {
        // String filePath =
        // "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\infclt.txt";
        String filePath = "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\url112-gbk.txt";
        List<String> msglist = readFile(filePath);
        AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
        try {
            for (String msg : msglist) {
                msg = "SZx.bHnYnymJV5IS4EowPYwaPQBNm1r7Nt.q3z57cCnhx5VgCC2GmS6fHzCO24GimydsT7KZ1uM9Xnl607sVrpUMlveHQcRIB1ZZz_RxWznS7RiejDcdddaAQLEHLFvlgyjxnnsj_oP13b765tM7Xjucbz1mkEp818gApwCEaOE.uDsXUVwKUEbOWv5erJGNBbjCRgzgIwjbjae2989n9Qq3havXSDK611sarvDFvsb3nWvk5RNHN_nNTfje66r6mena29nW_xri6GAVWAdS2dspxAYEwR2uw.YTk0POhNe5s56Unyi5fIarOsTRO_j0PT74LuWomP1KRt5S67wA2LB3Ox5VkU_xj_9FZaiFXJp5pdWJSNJoOXKXHDW7q5kl9VgcRUb8f78JtUu2XAC2INmi4AnuPPVUHHE8vZlRAA9EuaM0hG31eeKqF3E9CqKc02pXQLuyO6RvnQ1MuNfYQst0x48VtyMdGS5aCxu224k8MAExIqhA7.tcmCd3CjJ0yJXeWxrziLfifALRKMP38Tch8nI_gWwPrtr7RHI9sPE=";
                byte[] uncArr = Base64Util.base64ToByteArray(msg);
                byte[] decArr = aes.decrypt(uncArr);// 解密
                System.err.println(new String(decArr, "gb2312"));
                System.err.println(msg);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void doPost() {
        // String filePath =
        // "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\infclt.txt";
        String filePath = "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\url112-gbk.txt";
        List<String> msglist = readFile(filePath, 0);
        URLConnection urlConnection = null;
        OutputStreamWriter out = null;
        InputStream l_urlStream = null;
        BufferedReader l_reader = null;
        for (String msg : msglist) {
            try {
                // String urlStr =
                // "http://10.15.107.140:8088/jci/collectUserData?process_id=" +
                // processId + "&token_id=" + tokenId + "&version_code=" +
                // versionCode + "&msg_id=" + msgId + "&messages=" + msg;
                String urlS = "http://10.15.107.140:8088/jci/collectUserData";
                URL url = new URL(urlS);
                urlConnection = url.openConnection();
                urlConnection.setDoOutput(true);
                out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
                String urlStr = "process_id=" + processId + "&token_id=" + tokenId + "&version_code=" + versionCode + "&msg_id=" + msgId + "&messages=" + msg;
                out.write(urlStr);
                out.flush();
                l_urlStream = urlConnection.getInputStream();
                String sCurrentLine = "";
                String sTotalString = "";
                l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
                while ((sCurrentLine = l_reader.readLine()) != null) {
                    sTotalString = sTotalString + sCurrentLine + "\r\n";
                }
                System.out.println(sTotalString);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (l_reader != null)
                        l_reader.close();
                    if (l_urlStream != null)
                        l_urlStream.close();
                    if (out != null)
                        out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    private String packMsg(byte[] dataArr) {
        AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
        String str = null;
        try {
            byte[] enc = aes.encrypt(dataArr);
            // str = Base64Util.byteArrayToBase64(enc);
            str = new String(enc, "gb2312");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        // String filePath =
        // "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\infclt.txt";
        // readFile(filePath);
        // testResult();
        String filePath = "D:\\工作\\01.用户行为分析\\01.用户行为分析性能测试\\01.测试用例\\url112-gbk.txt";
        List<String> msglist = readFile(filePath, 0);
        int cpuS = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cpuS);
        WorkThread2 workThread2 = new WorkThread2(msglist, processId, tokenId, versionCode, msgId);
        for (int i = 0; i < 100; i++) {
            pool.execute(workThread2);
        }
        // doPost();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HttpPost httpPost = new HttpPost();
        httpPost.setProcessId("1");
        httpPost.setMsgId("2");
        httpPost.setTokenId("119OR949A4DxzeRSQJHYUxb07337fabc215c6c0c3a61043e12d75c119OR949A4");
        httpPost.setVersionCode("7.50.00.12367");
        Thread thread = new Thread(httpPost);
        thread.start();
    }
}
