package examples.springbootcrud.service;

import examples.springbootcrud.dto.User;
import examples.springbootcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    List<User> users = Collections.synchronizedList(new ArrayList());
    private long index = 0L;

    @Transactional
    public void addUser(User user){
        user.setId(++index);
        userRepository.save(user);
        //users.add(user);
    }
    @Transactional
    public void updateUser(User user){

        User tuser = userRepository.findById(user.getId()).get();
        tuser.setName(user.getName());
        tuser.setEmail(user.getEmail());

        /*int cnt = 0;

        for (User cuser: users){
            if(cuser.getId() == user.getId()){
                //userRepository.
                users.set(cnt,user);
                break;
            }
            cnt++;
        }*/
    }

    @Transactional
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(User user){
        userRepository.deleteById(user.getId());
    }
}
