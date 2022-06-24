package animenews.webs;

import animenews.ElasticsearchRepository.EPostRepository;
import animenews.entity.Post;
import animenews.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestControllersx {

    private final PostRepository postRepository;
    private final EPostRepository ePostRepository;

    public TestControllersx(PostRepository postRepository, EPostRepository ePostRepository) {
        this.postRepository = postRepository;
        this.ePostRepository = ePostRepository;
    }

    @RequestMapping("posts")
    @Transactional
    public Object getPots(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 200);
        Page<Post> postPage = postRepository.findAll(pageable);
        try {
            postPage.getContent().forEach(e -> {
                try {
                    ePostRepository.save(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        postRepository.flush();
        //        new Thread() {
//            @Transactional
//            @Override
//            public void run() {
//                Pageable pageable = PageRequest.of(0, 100);
//                Page<Post> postPage = postRepository.findAll(pageable);
//                ePostRepository.saveAll(postPage.getContent());
//                for (; postPage.hasNext(); ) {
//                    postPage = postRepository.findAll(postPage.nextOrLastPageable());
//                    ePostRepository.saveAll(postPage);
//                    postRepository.flush();
//                }
//
//            }
//        }.start();
        return "ok";
    }
}
