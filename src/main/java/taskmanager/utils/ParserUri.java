package taskmanager.utils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by employee on 11/28/16.
 */
public class ParserUri {

    private URI uri;

    public ParserUri(String uri) throws URISyntaxException {
        this.uri = new URI(uri);
    }

    public String getJDBCUrl(){
        return "jdbc:" + uri.toString()
                .replace(uri.getUserInfo() + "@", "").replace(":/", "ql:/");
    }

    public String getLogin(){
        return uri.getUserInfo().split(":")[0];
    }

    public String getPassword(){
        return uri.getUserInfo().split(":")[1];
    }
}
//postgres://postgres:root@localhost:5432/task_manager_db
