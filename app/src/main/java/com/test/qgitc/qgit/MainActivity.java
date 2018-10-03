package com.test.qgitc.qgit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] qint = new int[32];
    int queryType = 0;
    int resType = 0, tagLen = 0, tagCount = 0; //51713

    private EditText query_text;
    private TextView detected;
    private RelativeLayout resultGone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        query_text = (EditText) findViewById(R.id.takeQ);
        detected = (TextView) findViewById(R.id.tvDetect);
        resultGone = (RelativeLayout) findViewById(R.id.rl1);

        query_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                detectNS();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.page1_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_about:
//                Intent intent = new Intent(this, About.class);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//                return true;
//            default:
//                super.onOptionsItemSelected(item);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * takes query from editfield and returns it as long
     */
    private String getQ() {                                 //51713
        EditText q1 = (EditText) findViewById(R.id.takeQ);
        return (q1.getText().toString());
    }

    private void checkNs() {        //51713
        String q = getQ();
        int i = 0;
        int tag = 0;
        for (; i < q.length(); i++) {
            switch (q.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    tag++;
                    break;
                default:
                    checkS(q);
                    return;
            }
        }
        if (tag == q.length()) {
            checkI(q);
        }
    }

    /**
     * Method to check the String is hexadecimal or not.
     * if yes then converts the alphabets to number.
     * otherwise prints invalid term & shows toast.
     * Edited: Converts all String values to respective int value...!!!&_!3
     *
     * @param q is the String taken for test.
     */
    private void checkS(String q) {         //51713
        int i = 0;
        tagLen = 0;
        for (; i < q.length(); i++) {
            switch (q.charAt(i)) {
                case '0':
                    qint[i] = 0;
                    tagLen++;
                    break;
                case '1':
                    qint[i] = 1;
                    tagLen++;
                    break;
                case '2':
                    qint[i] = 2;
                    tagLen++;
                    break;
                case '3':
                    qint[i] = 3;
                    tagLen++;
                    break;
                case '4':
                    qint[i] = 4;
                    tagLen++;
                    break;
                case '5':
                    qint[i] = 5;
                    tagLen++;
                    break;
                case '6':
                    qint[i] = 6;
                    tagLen++;
                    break;
                case '7':
                    qint[i] = 7;
                    tagLen++;
                    break;
                case '8':
                    qint[i] = 8;
                    tagLen++;
                    break;
                case '9':
                    qint[i] = 9;
                    tagLen++;
                    break;
                case 'a':
                case 'A':
                    qint[i] = 10;
                    tagLen++;
                    break;
                case 'b':
                case 'B':
                    qint[i] = 11;
                    tagLen++;
                    break;
                case 'c':
                case 'C':
                    qint[i] = 12;
                    tagLen++;
                    break;
                case 'd':
                case 'D':
                    qint[i] = 13;
                    tagLen++;
                    break;
                case 'e':
                case 'E':
                    qint[i] = 14;
                    tagLen++;
                    break;
                case 'f':
                case 'F':
                    qint[i] = 15;
                    tagLen++;
                    break;
                default:
                    queryType = 5;
                    Toast.makeText(this,
                            "Invalid term. Please enter a valid term.",
                            Toast.LENGTH_SHORT).show();
                    return;
            }
        }
        queryType = 4;  //queryType = 4 represents hexadecimal number system
    }

    /**
     * method to check if the given String is binary, octal, or decimal using tags values.
     * Edited: Converts all String values to respective int value...!!!&_!3
     *
     * @param q is the String taken for test.
     */
    private void checkI(String q) {         //51713
        int i = 0;
        int tag = 0;
        tagLen = 0;
        for (; i < q.length(); i++) {
            switch (q.charAt(i)) {
                case '0':
                    qint[i] = 0;
                    tagLen++;
                    break;
                case '1':
                    qint[i] = 1;
                    tagLen++;
                    break;
                case '2':
                    qint[i] = 2;
                    tagLen++;
                    break;
                case '3':
                    qint[i] = 3;
                    tagLen++;
                    break;
                case '4':
                    qint[i] = 4;
                    tagLen++;
                    break;
                case '5':
                    qint[i] = 5;
                    tagLen++;
                    break;
                case '6':
                    qint[i] = 6;
                    tagLen++;
                    break;
                case '7':
                    qint[i] = 7;
                    tagLen++;
                    break;
                case '8':
                    qint[i] = 8;
                    tagLen++;
                    break;
                case '9':
                    qint[i] = 9;
                    tagLen++;
                    break;
                default:
                    queryType = 5;
                    Toast.makeText(this,
                            "Invalid term. Please enter a valid term.",
                            Toast.LENGTH_SHORT).show();
            }
        }

        for (i = 0; i < q.length(); i++) {
            if (qint[i] == 0 || qint[i] == 1) {
                tag += 1;
            } else if (qint[i] < 8) {
                tag += 8;
            } else if (qint[i] < 10 && qint[i] > 7) {
                tag += 10;
            }
        }
        if (tag == q.length() && tag != 0 && qint[0] == 0) {
            queryType = 1; //queryType = 1 represents binary number system
        } else if (tag != 0) {
            queryType = 2; //queryType = 2 represents decimal number system
        }

    }

    private void setDetect() {                                                  //51713
        resultGone.setVisibility(View.GONE);
        String caseT = null;
        switch (queryType) {
            case 1:
                caseT = "Binary";
                break;
            case 2:
                caseT = "Decimal";
                break;
            case 3:
                caseT = "Octal";
                break;
            case 4:
                caseT = "Hexadecimal";
                break;
            case 5:
                caseT = "Invalid Entry";
                break;
            default:
                caseT = "Empty";
        }

        detected.setText(" Detected : " + caseT);
    }

    public void detectNS() {           //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        if (test1.equals("showCreator51713")) {
            showCreator();
            return;
        }
        checkNs();
        setDetect();
    }

    public void detectNS(View view) {           //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        if (test1.equals("showCreator51713")) {
            showCreator();
            return;
        }
        checkNs();
        setDetect();
    }

    private void emptyEntry() {
        queryType = 0;
        setDetect();
        // Toast.makeText(this, " It seems you have not entered a number.\n
        //  Enter a number first then try again.", Toast.LENGTH_SHORT).show() ;
        detected.setText("It seems you have not entered a number.\n" +
                " Enter a number first then try again.");
    }

    protected void showCreator() {                                             //51713
        RelativeLayout resLayout = (RelativeLayout) findViewById(R.id.rl1);
        resLayout.setVisibility(View.VISIBLE);
        TextView showContent = (TextView) findViewById(R.id.res);
        showContent.setText(" Created By : Sumit K Burnwal " + "\n" + " SK!3 ");
    }

    public void setQTH(View view) {         //51713
        detectNS(view);
        queryType = 4; //Hexadecimal
        setDetect();
    }

    public void setQTB(View view) {                 //51713
        detectNS(view);
        if (queryType != 4 && queryType != 2 && queryType != 3 && queryType != 5) {
            queryType = 1; //Binary
            setDetect();
        } else {
            Toast.makeText(this, "Cannot be Binary ", Toast.LENGTH_SHORT).show();
        }
    }

    public void setQTD(View view) {         //51713
        detectNS(view);
        if (queryType != 4) {
            queryType = 2; //Decimal
            setDetect();
        } else {
            Toast.makeText(this, "Cannot be Decimal ", Toast.LENGTH_SHORT).show();
        }
    }

    public void setQTO(View view) {                 //51713
        detectNS(view);
        boolean check = false;
        for (int i = 0; i < tagLen; i++) {
            if (qint[i] > 7) {
                check = true;
                break;
            }
        }
        if (queryType == 4 || check) {
            Toast.makeText(this, "Cannot be Octal ", Toast.LENGTH_SHORT).show();
        } else {
            queryType = 3; //Octal
            setDetect();
        }
    }


    private String d2b(int d) {             //51713
        String res = expand(d, 2);
        return res;
    }

    private String d2h(int d) {             //51713
        String res = expand(d, 16, 16);
        return res;
    }

    private String d2o(int d) {             //51713
        String res = expand(d, 8);
        return res;
    }


    private int b2d() {                     //51713
        int dig = compact(2);
        return dig;
    }

    private int o2d() {                     //51713
        int dig = compact(8);
        return dig;
    }

    private int h2d() {                     //51713
        int dig = compact(6);
        return dig;
    }


    private String b2o() {                  //51713
        int st1 = b2d();
        String res = d2o(st1);
        return res;
    }

    private String b2h() {                  //51713
        int st1 = b2d();
        String res = d2h(st1);
        return res;
    }

    private String o2b() {                  //51713
        int st1 = o2d();
        String res = d2b(st1);
        return res;
    }

    private String o2h() {                  //51713
        int st1 = o2d();
        String res = d2h(st1);
        return res;
    }

    private String h2b() {                  //51713
        int st1 = h2d();
        String res = d2b(st1);
        return res;
    }

    private String h2o() {                  //51713
        int st1 = h2d();
        String res = d2o(st1);
        return res;
    }


    /**
     * solving  for expanded number system
     */
    private String expand(int d, int base) {    //51713
        int[] x = getConv(d, base);
        String ces = "";
        int i = tagCount;
        for (; i >= 0; i--) {
            ces = ces + x[i];
        }
        return ces;
    }

    /**
     * solving  for expanded number system
     */
    private String expand(int d, int base, int hex) {   //51713
        int[] x = getConv(d, base);
        String ces;
        char[] hexChar = new char[32];
        for (int i = tagCount; i >= 0; i--) {
            switch (x[i]) {
                case 1:
                    hexChar[tagCount - i] = '1';
                    break;
                case 2:
                    hexChar[tagCount - i] = '2';
                    break;
                case 3:
                    hexChar[tagCount - i] = '3';
                    break;
                case 4:
                    hexChar[tagCount - i] = '4';
                    break;
                case 5:
                    hexChar[tagCount - i] = '5';
                    break;
                case 6:
                    hexChar[tagCount - i] = '6';
                    break;
                case 7:
                    hexChar[tagCount - i] = '7';
                    break;
                case 8:
                    hexChar[tagCount - i] = '8';
                    break;
                case 9:
                    hexChar[tagCount - i] = '9';
                    break;
                case 10:
                    hexChar[tagCount - i] = 'A';
                    break;
                case 11:
                    hexChar[tagCount - i] = 'B';
                    break;
                case 12:
                    hexChar[tagCount - i] = 'C';
                    break;
                case 13:
                    hexChar[tagCount - i] = 'D';
                    break;
                case 14:
                    hexChar[tagCount - i] = 'E';
                    break;
                case 15:
                    hexChar[tagCount - i] = 'F';
                    break;
                default:
                    hexChar[tagCount - i] = '*';
            }
        }
        ces = String.valueOf(hexChar);
        return ces;
    }

    /**
     * solving an array for compact number system
     */
    private int compact(int base) {         //51713
        int sum = 0;
        int i = 0;
        for (; i < tagLen; i++) {
            sum = sum + (int) (qint[i] * Math.pow(base, (tagLen - 1 - i)));
        }
        return sum;
    }

    /**
     * converts number to array of other number system with different bases
     */
    private int[] getConv(int num, int base) {          //51713
        int i = 0;
        tagCount = 0;
        int[] res = new int[32];
        while (num >= base) {
            res[i] = (num % base);
            num /= base;
            i++;
            tagCount++;
        }
        res[i] = num;
        return res;
    }


    /**
     * writes result on result textview
     */
    private void putQ(String str, int resType) {          //51713
        String defType = "Empty", qType = "Empty";
        RelativeLayout resLayout = (RelativeLayout) findViewById(R.id.rl1);
        resLayout.setVisibility(View.VISIBLE);
        switch (resType) {
            case 1:
                defType = "Binary";
                break;
            case 2:
                defType = "Decimal";
                break;
            case 3:
                defType = "Octal";
                break;
            case 4:
                defType = "Hexadecimal";
                break;
        }
        switch (queryType) {
            case 1:
                qType = "Binary";
                break;
            case 2:
                qType = "Decimal";
                break;
            case 3:
                qType = "Octal";
                break;
            case 4:
                qType = "Hexadecimal";
                break;
        }
        TextView deft = (TextView) findViewById(R.id.tvDef);
        deft.setText(qType + " -->> " + defType);
        TextView r1 = (TextView) findViewById(R.id.res);
        r1.setText(str);
    }

    /**
     * Button call for conversion to hex
     *
     * @param view
     */
    public void conv2hex(View view) {           //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        resType = 4;
        String res;
        switch (queryType) {
            case 1:
                res = b2h();
                break;
            case 2:
                int i1 = compact(10);
                res = d2h(i1);
                break;
            case 3:
                res = o2h();
                break;
            case 4:
                Toast.makeText(this, " Already a Hexadecimal number.\n" +
                        " Try another number. ", Toast.LENGTH_SHORT).show();
                EditText q1 = (EditText) findViewById(R.id.takeQ);
                res = q1.getText().toString();
                break;
            default:
                res = "Invalid";
        }

        putQ(res, resType);
    }

    public void conv2bin(View view) {       //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        resType = 1;
        String res;
        switch (queryType) {
            case 1:
                Toast.makeText(this, " Already a Binary number.\n" +
                        " Try another number. ", Toast.LENGTH_SHORT).show();
                EditText q1 = (EditText) findViewById(R.id.takeQ);
                res = q1.getText().toString();
                break;
            case 2:
                int i1 = compact(10);
                res = d2b(i1);
                break;
            case 3:
                res = o2b();
                break;
            case 4:
                res = h2b();
                break;
            default:
                res = "Invalid";
        }
        putQ(res, resType);
    }

    public void conv2dec(View view) {       //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        resType = 2;
        int num;
        String res;
        switch (queryType) {
            case 1:
                num = b2d();
                res = ("" + num);
                break;
            case 2:
                Toast.makeText(this, " Already a Decimal number.\n" +
                        " Try another number. ", Toast.LENGTH_SHORT).show();
                EditText q1 = (EditText) findViewById(R.id.takeQ);
                res = q1.getText().toString();
                break;
            case 3:
                num = o2d();
                res = ("" + num);
                break;
            case 4:
                num = h2d();
                res = ("" + num);
                break;
            default:
                res = "Invalid";
        }
        putQ(res, resType);
    }

    public void conv2oct(View view) {       //51713
        String test1 = getQ();
        if (test1.equals("")) {
            emptyEntry();
            return;
        }
        resType = 3;
        String res;
        switch (queryType) {
            case 1:
                res = b2o();
                break;
            case 2:
                int i1 = compact(10);
                res = d2o(i1);
                break;
            case 3:
                Toast.makeText(this, " Already a Octal number.\n" +
                        " Try another number. ", Toast.LENGTH_SHORT).show();
                EditText q1 = (EditText) findViewById(R.id.takeQ);
                res = q1.getText().toString();
                break;
            case 4:
                res = h2o();
                break;
            default:
                res = "Invalid";
        }
        putQ(res, resType);
    }

}