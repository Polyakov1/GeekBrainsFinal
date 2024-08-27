package DB;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.stereotype.Component;

import java.sql.*;
@Getter
@Setter
@DependsOnDatabaseInitialization
public class DataBase {
}
