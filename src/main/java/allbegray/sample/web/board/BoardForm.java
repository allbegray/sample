package allbegray.sample.web.board;

import allbegray.sample.entity.Board;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by allbegray on 2016-08-31.
 */
public class BoardForm {

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private MultipartFile file;

    public BoardForm() {
    }

    public BoardForm(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
