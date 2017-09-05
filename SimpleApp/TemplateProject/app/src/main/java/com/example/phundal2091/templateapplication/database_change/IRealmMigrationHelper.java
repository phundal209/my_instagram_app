package com.example.phundal2091.templateapplication.database_change;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmMigration;

/**
 * Created by GoFundMe on 1/11/17.
 */

public interface IRealmMigrationHelper {
    Realm doDatabaseMigration(Context context);
    RealmMigration migrate();

}
