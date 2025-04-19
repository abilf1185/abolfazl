   public void btnFire_Click(View view) {

        if(Fullname == "NULL")
        {
            Toast.makeText(getApplicationContext(), "پیش از پرتاب لازم است خود را معرفی کنید",
                    Toast.LENGTH_LONG).show();
            return;
        }
        AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
        alert.setTitle("پرتاب موشک");
        alert.setMessage("آیا از پرتاب موشک اطمینان دارید؟");
        alert.setButton(AlertDialog.BUTTON_POSITIVE, "پرتاب",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), Fullname +  ", موشک با موفقیت ارسال شد" ,
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
        alert.setButton(AlertDialog.BUTTON_NEGATIVE, "انصراف",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );

        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "بیکار",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );


        alert.show();
    }



// -----------------------------------------------------------------------------



    String Fullname;
    public void btnWho_Click(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("شما چه کسی هستید که میخواهید موشک ارسال کنید؟");


// Set up the input
        final EditText txtName = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        txtName.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(txtName);


        builder.setPositiveButton("OK", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Fullname = txtName.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }