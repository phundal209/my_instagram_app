package com.example.phundal2091.templateapplication.database_change;

import android.content.Context;
import android.util.Log;

import com.example.phundal2091.templateapplication.R;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

import static okhttp3.internal.Internal.logger;

/**
 * Created by GoFundMe on 1/11/17.
 */

public class RealmMigrationHelper implements IRealmMigrationHelper{
    private static final String TAG = RealmMigrationHelper.class.getSimpleName();

    @Override
    public Realm doDatabaseMigration(Context context) {
        try {
            RealmConfiguration db_config = new RealmConfiguration.Builder(context)
                    .schemaVersion(context.getResources().getInteger(R.integer.schema_version))
                    .migration(migrate())
                    .build();

            Realm.setDefaultConfiguration(db_config);
        } catch (Exception ex) {
            Log.d(TAG, ex.getMessage(), ex);
        }
        // This will automatically trigger the migration if needed
        Realm realm = Realm.getDefaultInstance();
        return realm;
    }

    @Override
    public RealmMigration migrate() {
        RealmMigration realmMigration = new RealmMigration() {
            @Override
            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                // call migration function here
            }
        };
        return realmMigration;
    }
}
