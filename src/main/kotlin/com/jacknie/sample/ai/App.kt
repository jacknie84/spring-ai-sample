package com.jacknie.sample.ai

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class App {

	@Bean
	fun commandLineRunner(chatModel: VertexAiGeminiChatModel) = CommandLineRunner {
		val response = chatModel.call("""
			자체 평가와 동료 평가 구조 설계
			
			무엇을 평가?
			ㄴ업무 숙련도
			ㄴ협업 능력 및 태도
			ㄴ문제 해결 능력
			ㄴ의사소통 능력
			
			피드백 유형
			ㄴ 정량적 - 5점 척도 등급
			ㄴ 정성적 - 서술형(구체적인 사례 작성)
			
			평가 대상
			ㄴ개인
			
			평가 수행
			ㄴ동료
			
			평가 도구
			ㄴ 온라인 설문조사
			
			앞선 내용을 바탕으로 설문지 예시 생성
		""")
		println(response)
	}
}

fun main(args: Array<String>) {
	runApplication<App>(*args)
}
