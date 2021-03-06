package com.example.finartz_project.scheldure;

import com.example.finartz_project.model.dto.MemberDto;
import com.example.finartz_project.model.entity.MemberEntity;
import com.example.finartz_project.repository.MemberRepository;
import com.example.finartz_project.service.internal.MailService;
import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@Configuration
@EnableScheduling
public class BirthDayMail {
    private final MemberRepository memberRepository;
    private final MailService mailService;

    public BirthDayMail(MemberRepository memberRepository, MailService mailService) {

        this.memberRepository = memberRepository;
        this.mailService = mailService;
    }

    @Scheduled(cron="*/5 * * * * *", zone="Europe/Istanbul")
    public void sendBirthdayMail() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        List<MemberDto> members = convert(memberEntities);
        if (members.size()>0){

            members.stream()
                    .filter(isMemberBirthDateToday())
                    .forEach(member->{
                        //mailService.sendBirthDayNotification(memberDto);
                        System.out.println("It has an empty body");

                    });
        }

    }
    private Predicate<MemberDto> isMemberBirthDateToday(){
        return memberDto -> memberDto.getBirthDay().getMonth().equals(LocalDateTime.now().getMonth())
                &&memberDto.getBirthDay().getDayOfMonth()==LocalDateTime.now().getDayOfMonth();
    }
    @NotNull
    public List<MemberDto> convert(List<MemberEntity>  source) {

        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private MemberDto convert(MemberEntity source) {
        if (source == null) {
            return null;//Exception don null yerine
        }
        MemberDto target = new MemberDto();
        target.setMemberId(source.getMemberId());
        target.setBirthDay(source.getBirthDay());
        target.setName(source.getName());
        return target;

    }

    //            for (MemberDto memberDto : members) {
//
//                if (memberDto.getBirthDay().getMonth().equals(LocalDateTime.now().getMonth())
//                        &&memberDto.getBirthDay().getDayOfMonth()==LocalDateTime.now().getDayOfMonth()){
//                    //mailService.sendBirthDayNotification(memberDto);
//                    System.out.println("It has an empty body");
//                }
//
//
//            }

}





