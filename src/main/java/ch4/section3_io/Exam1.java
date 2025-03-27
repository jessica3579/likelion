package ch4.section3_io;

import java.io.*;

// 로그인 > 마이페이지 > 훈련관리 >직업훈련이력 > 정산현황
public class Exam1 {
    public static void main(String[] args) {
        try{
            // file을 byte로 읽는 역할...
            FileInputStream fis = new FileInputStream("c:\\Temp\\data.txt");
            // byte를 문자열로 변형시켜주는 stream을 연결해서...
            // 문자열 인코딩 타입 문제로.. 한글이 깨질 수 있다..
            // UTR=8, EUC-KR
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bin = new BufferedReader(isr);

            StringBuffer sb = new StringBuffer();
            String line = "";
            // 한줄씩 읽어서 line에 저장.. 더 이상 읽을 수 없으면 null
            while((line=bin.readLine())!= null){
                System.out.println("read: " + line);
                sb.append(line);
            }
            // File - 실제 데이터 in/out 역할은 아니고.. 파일 혹은 디렉토리를 지칭하기 위한
            File dir = new File("c:\\work");
            dir.mkdir(); // 디렉토리 만들고...

            File file = new File(dir, "result.txt");
            file.createNewFile();

            if(dir.isDirectory()){
                System.out.println(dir.getName()+" 은 디렉토리입니다.");
            }
            if(file.isFile()){
                System.out.println(file.getName()+" 은 파일입니다.");
            }
            if(file.exists()){
                System.out.println("1111111111");
                PrintWriter out = new PrintWriter(file); // file에 쓰는 것!
                out.println(sb.toString());
                out.flush();
                out.close();

                System.out.println(file.getAbsolutePath());
                System.out.println(file.length());
            }

            File cDir = new File("c:\\");
            String[] fileNames = cDir.list();
            for (String name: fileNames){
                System.out.println(name);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
