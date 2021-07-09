package br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger;

import org.h2.tools.TriggerAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class CreatedAtTrigger extends TriggerAdapter {

    @Override
    public void fire(Connection connection, ResultSet oldRow, ResultSet newRow) throws SQLException {
        newRow.updateTimestamp("created_at", Timestamp.from(Instant.now()));
    }
}
