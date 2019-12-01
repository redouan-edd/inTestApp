package com.example.intest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public List<Integer> mDomainItems = new ArrayList<>();
    public List<Integer> mTypeItems = new ArrayList<>();
    public List<Integer> mReqItems = new ArrayList<>();
    public List<Integer> mSkillsrItems = new ArrayList<>();
    public List<String> domainList ;
    public List<String> typeList ;
    public List<String> reqList ;
    public List<String> skillsList ;

    /*----  Domaine ----*/
    TextView domaineItemSelected;
    Button domaineItemsBtn;
    String[] domaineListItems;


      /*----  Types ----*/
    TextView TypeItemSelected;
    Button TypeItemsBtn;
    String[] TypeListItems;



    /* -- Requirements -- */
    TextView requiremtnItemSelected;
    Button RequirementsItemsBtn;
    String[] requirementListItems;

    /* -- Skills -- */
    TextView skillsItemSelected;
    Button skillsItemsBtn;
    String[] skillsListItems;

    /* -- poustuler btn --*/
    private  Button poustulerBtn;

    /* -- title offre --*/
    private EditText TittleOffre;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        domainList=new ArrayList<>();
        reqList=new ArrayList<>();
        skillsList=new ArrayList<>();
        typeList=new ArrayList<>();


        /* +++ Domaine +++ */
        domaineItemsBtn = (Button) findViewById(R.id.id_Domain);
        domaineItemSelected = (TextView) findViewById(R.id.id_TextDomaine);
        domaineListItems = getResources().getStringArray(R.array.domaine_item);

        /* +++ Types +++ */
        TypeItemsBtn = (Button) findViewById(R.id.id_Type);
        TypeItemSelected = (TextView) findViewById(R.id.id_TextType);
        TypeListItems = getResources().getStringArray(R.array.type_item);

         /* +++ Requirement +++ */
        RequirementsItemsBtn = (Button) findViewById(R.id.id_Requiremments);
        requiremtnItemSelected = (TextView) findViewById(R.id.id_TextRequiremments);
        requirementListItems = getResources().getStringArray(R.array.requirement_item);

         /* +++ Skills +++ */
        skillsItemsBtn = (Button) findViewById(R.id.id_Skills);
        skillsItemSelected = (TextView) findViewById(R.id.id_TextSkills);
        skillsListItems = getResources().getStringArray(R.array.skills_item);

        /* -- poustuler btn --*/

        poustulerBtn = (Button) findViewById(R.id.postule_Btn);


        /* -- Title offre --*/

        TittleOffre = (EditText) findViewById(R.id.id_TittleOffre);





        domaineItemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showListItemes(domaineListItems,domaineItemSelected);



            }
        });

        TypeItemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showTypeListItemes(TypeListItems,TypeItemSelected);



            }
        });



        RequirementsItemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showReqListItemes(requirementListItems,requiremtnItemSelected);

            }
        });

        skillsItemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSkillsListItemes(skillsListItems,skillsItemSelected);
            }
        });

        poustulerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            postuler();


            Log.d("test ",""+domainList.size());
            Log.d("test ",""+typeList.size());
            Log.d("req ",""+reqList.size());
            Log.d("ski ",""+skillsList.size());

            }
        });
    }









    private void postuler(){


        if(TittleOffre.getText().toString().isEmpty() &&  domainList.isEmpty() && typeList.isEmpty() && reqList.isEmpty() && skillsList.isEmpty()){
            Toast.makeText(MainActivity.this,"Please valide your data !",Toast.LENGTH_SHORT).show();

            domaineItemSelected.setText("please select a choice !");
            domaineItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));

            TypeItemSelected.setText("please select a choice !");
            TypeItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));

            requiremtnItemSelected.setText("please select a choice !");
            requiremtnItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
            skillsItemSelected.setText("please select a choice !");
            skillsItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        else {
            if (domainList.isEmpty()) {
                domaineItemSelected.setText("please select a choice !");
                domaineItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            if (typeList.isEmpty()) {
                TypeItemSelected.setText("please select a choice !");
                TypeItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            if (reqList.isEmpty()) {
                requiremtnItemSelected.setText("please select a choice !");
                requiremtnItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
            }
            if (skillsList.isEmpty()) {
                skillsItemSelected.setText("please select a choice !");
                skillsItemSelected.setTextColor(getResources().getColor(R.color.colorAccent));
            }

        }
    }


    private void showListItemes(final String[] itemsResTab, final TextView textView){

        final boolean[] checkedItems;

        checkedItems = new boolean[itemsResTab.length];

        domainList= new ArrayList<>();
        
    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

    mBuilder.setTitle(R.string.dialog_title);

    mBuilder.setMultiChoiceItems(itemsResTab, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

            if(isChecked){
                mDomainItems.add(position);
            }else{
                mDomainItems.remove((Integer.valueOf(position)));
            }
        }
    });

    mBuilder.setCancelable(false);

    mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {

            String item = "";
            for (int i = 0; i < mDomainItems.size(); i++) {
                if(! domainList.contains(itemsResTab[mDomainItems.get(i)] )) {
                    item = item + itemsResTab[mDomainItems.get(i)] + ", ";
                    domainList.add(itemsResTab[mDomainItems.get(i)]);

                }
            }
            if(item.equals("")){
                textView.setText("no items selected !");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
            }else {
                textView.setText(item);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));}
        }
    });

    mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    });

    mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            domainList.clear();
            for (int i = 0; i < checkedItems.length; i++) {
                checkedItems[i] = false;}

            mDomainItems.clear();
            textView.setText("no items selected !");
            textView.setTextColor(getResources().getColor(R.color.colorAccent));


        }
    });

    AlertDialog mDialog = mBuilder.create();
    mDialog.show();

}


/* --------------------------------------------------------------------------------------------------------------------------------*/

    private void showReqListItemes(final String[] itemsResTab, final TextView textView){

        final boolean[] checkedReqItems;

        checkedReqItems = new boolean[itemsResTab.length];

        reqList= new ArrayList<>();
        //   reqList= new ArrayList<>();
        // skillsList= new ArrayList<>();



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

        mBuilder.setTitle(R.string.dialog_title);

        mBuilder.setMultiChoiceItems(itemsResTab, checkedReqItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

                if(isChecked){
                    mReqItems.add(position);
                }else{
                    mReqItems.remove((Integer.valueOf(position)));
                }
            }
        });

        mBuilder.setCancelable(false);

        mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                String item = "";
                for (int i = 0; i < mReqItems.size(); i++) {
                    if(! reqList.contains(itemsResTab[mReqItems.get(i)] )) {
                        item = item + itemsResTab[mReqItems.get(i)] + ", ";
                        reqList.add(itemsResTab[mReqItems.get(i)]);

                    }
                }
                if(item.equals("")){
                    textView.setText("no items selected !");
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                }else {
                    textView.setText(item);
                    textView.setTextColor(getResources().getColor(R.color.colorPrimary));}

            }
        });

        mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                reqList.clear();
                for (int i = 0; i < checkedReqItems.length; i++) {
                    checkedReqItems[i] = false;}

                mReqItems.clear();

                textView.setText("no items selected !");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));



            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }





    /* --------------------------------------------------------------------------------------------------------------------------------*/

    private void showSkillsListItemes(final String[] itemsResTab, final TextView textView){

        final boolean[] checkedskillsItems;

        checkedskillsItems = new boolean[itemsResTab.length];

        skillsList= new ArrayList<>();
        //   reqList= new ArrayList<>();
        // skillsList= new ArrayList<>();



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

        mBuilder.setTitle(R.string.dialog_title);

        mBuilder.setMultiChoiceItems(itemsResTab, checkedskillsItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

                if(isChecked){
                    mSkillsrItems.add(position);
                }else{
                    mSkillsrItems.remove((Integer.valueOf(position)));
                }
            }
        });

        mBuilder.setCancelable(false);

        mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                String item = "";
                for (int i = 0; i < mSkillsrItems.size(); i++) {
                    if(! skillsList.contains(itemsResTab[mSkillsrItems.get(i)] )) {
                        item = item + itemsResTab[mSkillsrItems.get(i)] + ", ";
                        skillsList.add(itemsResTab[mSkillsrItems.get(i)]);

                    }
                }


                if(item.equals("")){
                    textView.setText("no items selected !");
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                }else {
                textView.setText(item);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));}


            }
        });

        mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                skillsList.clear();
                for (int i = 0; i < checkedskillsItems.length; i++) {
                    checkedskillsItems[i] = false;}

                mSkillsrItems.clear();

                textView.setText("no items selected !");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));

                
                


            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }
    /* --------------------------------------------------------------------------------------------------------------------------------*/

    private void showTypeListItemes(final String[] itemsResTab, final TextView textView){

        final boolean[] checkedTypesItems;

        checkedTypesItems = new boolean[itemsResTab.length];

        typeList= new ArrayList<>();




        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

        mBuilder.setTitle(R.string.dialog_title);

        mBuilder.setMultiChoiceItems(itemsResTab, checkedTypesItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {

                if(isChecked){
                    mSkillsrItems.add(position);
                }else{
                    mSkillsrItems.remove((Integer.valueOf(position)));
                }
            }
        });

        mBuilder.setCancelable(false);

        mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                String item = "";
                for (int i = 0; i < mSkillsrItems.size(); i++) {
                    if(! typeList.contains(itemsResTab[mSkillsrItems.get(i)] )) {
                        item = item + itemsResTab[mSkillsrItems.get(i)] + ", ";
                        typeList.add(itemsResTab[mSkillsrItems.get(i)]);

                    }
                }


                if(item.equals("")){
                    textView.setText("no items selected !");
                    textView.setTextColor(getResources().getColor(R.color.colorAccent));
                }else {
                textView.setText(item);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));}


            }
        });

        mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                typeList.clear();
                for (int i = 0; i < checkedTypesItems.length; i++) {
                    checkedTypesItems[i] = false;}

                mSkillsrItems.clear();

                textView.setText("no items selected !");
                textView.setTextColor(getResources().getColor(R.color.colorAccent));





            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }


}
