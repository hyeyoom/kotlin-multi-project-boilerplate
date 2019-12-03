package com.github.hyeyoom.kmp.usecase.core

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

interface UseCase<in Request, out Response> {
    fun execute(request: Request): Response
}

interface UseCaseExecutor {
    operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): CompletionStage<ResponseDto>
}

class UseCaseExecutorImp : UseCaseExecutor {
    override operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): CompletionStage<ResponseDto> =
        CompletableFuture
            .supplyAsync { requestConverter(requestDto) }
            .thenApplyAsync { useCase.execute(it) }
            .thenApplyAsync { responseConverter(it) }
}