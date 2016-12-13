package net.monitor.http;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class WorkThread2 implements Runnable {

    private List<String> msglist;

    private String processId = "1";

    private String tokenId = "2";

    private String versionCode;

    private String msgId;

    public WorkThread2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public WorkThread2(List<String> msglist) {
        super();
        this.msglist = msglist;
    }

    public WorkThread2(List<String> msglist, String processId, String tokenId, String versionCode, String msgId) {
        super();
        this.msglist = msglist;
        this.processId = processId;
        this.tokenId = tokenId;
        this.versionCode = versionCode;
        this.msgId = msgId;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void doPost() {

        URLConnection urlConnection = null;
        OutputStreamWriter out = null;
        InputStream l_urlStream = null;
        BufferedReader l_reader = null;
        for (String msg : msglist) {
            try {
                String urlS = "http://10.15.107.140:8088/jci/collectUserData";
                URL url = new URL(urlS);
                urlConnection = url.openConnection();
                urlConnection.setDoOutput(true);
                out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
                String urlStr = "process_id=" + processId + "&token_id=" + tokenId + "&version_code=" + versionCode + "&msg_id=" + msgId + "&messages=" + msg;
                System.err.println(urlS + "?" + urlStr);
                out.write(urlStr);
                out.flush();
                l_urlStream = urlConnection.getInputStream();
                String sCurrentLine = "";
                // String sTotalString = "";
                l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
                while ((sCurrentLine = l_reader.readLine()) != null) {
                    // sTotalString = sTotalString + sCurrentLine + "\r\n";
                }
                // System.out.println(sTotalString);

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

    public List<String> getMsglist() {
        return msglist;
    }

    public void setMsglist(List<String> msglist) {
        this.msglist = msglist;
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
        doPost();
    }
}
