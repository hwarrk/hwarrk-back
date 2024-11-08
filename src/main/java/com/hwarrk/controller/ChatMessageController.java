package com.hwarrk.controller;

import com.hwarrk.common.apiPayload.CustomApiResponse;
import com.hwarrk.common.dto.req.ChatMessageReq;
import com.hwarrk.common.dto.res.MessageRes;
import com.hwarrk.service.ChatMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @MessageMapping("chat.message")
    public CustomApiResponse sendMessage(ChatMessageReq message) {
        chatMessageService.sendMessage(message);
        return CustomApiResponse.onSuccess();
    }

    @Operation(summary = "채팅내역 조회",
            description = "프로필에서 메시지 보내기 클릭 시 채팅내역 조회 선행 후 CHAT_ROOM4041을 반환받으면 채팅방 생성 API 호출",
            responses = {
                    @ApiResponse(responseCode = "MEMBER4001", description = "사용자를 찾을 수 없습니다"),
                    @ApiResponse(responseCode = "CHAT_ROOM4041", description = "채팅방 찾을 수 없습니다"),
                    @ApiResponse(responseCode = "CHAT_ROOM_MEMBER4031", description = "채팅방에 참여 중인 사용자가 아닙니다")
            })
    @GetMapping("/chat-messages/chat-room/{chatRoomId}")
    public CustomApiResponse<List<MessageRes>> getChatMessages(@AuthenticationPrincipal Long loginId,
                                                               @PathVariable Long chatRoomId) {
        List<MessageRes> chatMessageResList = chatMessageService.getChatMessages(loginId, chatRoomId);
        return CustomApiResponse.onSuccess(chatMessageResList);
    }
}