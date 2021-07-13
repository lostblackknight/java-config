package io.github.lostbalckknight.common;

/**
 * @author chensixiang chensixiang1234@gmail.com
 */
public enum Code {
    Continue(100, "这个临时响应表明，迄今为止的所有内容都是可行的，客户端应该继续请求，如果已经完成，则忽略它。"),

    SwitchingProtocol(101, "该代码是响应客户端的Upgrade(en-US)标头发送的，并且指示服务器也正在切换的协议。"),

    Processing(102, "此代码表示服务器已收到并正在处理该请求，但没有响应可用。"),

    EarlyHints(103, "此状态代码主要用于与Link链接头一起使用，以允许用户代理在服务器仍在准备响应时开始预加载资源。"),

    OK(200, "请求成功。"),

    Created(201, "该请求已成功，并因此创建了一个新的资源。这通常是在POST请求，或是某些PUT请求之后返回的响应。"),

    Accepted(202, "请求已经接收到，但还未响应，没有结果。意味着不会有一个异步的响应去表明当前请求的结果，预期另外的进程和服务去处理请求，或者批处理。"),

    NonAuthoritativeInformation(203, "服务器已成功处理了请求，但返回的实体头部元信息不是在原始服务器上有效的确定集合，而是来自本地或者第三方的拷贝。当前的信息可能是原始版本的子集或者超集。例如，包含资源的元数据可能导致原始服务器知道元信息的超集。使用此状态码不是必须的，而且只有在响应不使用此状态码便会返回200 OK的情况下才是合适的。"),

    NoContent(204, "服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。响应可能通过实体头部的形式，返回新的或更新后的元信息。如果存在这些头部信息，则应当与所请求的变量相呼应。如果客户端是浏览器的话，那么用户浏览器应保留发送了该请求的页面，而不产生任何文档视图上的变化，即使按照规范新的或更新后的元信息应当被应用到用户浏览器活动视图中的文档。由于204响应被禁止包含任何消息体，因此它始终以消息头后的第一个空行结尾。"),

    ResetContent(205, "服务器成功处理了请求，且没有返回任何内容。但是与204响应不同，返回此状态码的响应要求请求者重置文档视图。该响应主要是被用于接受用户输入后，立即重置表单，以便用户能够轻松地开始另一次输入。与204响应一样，该响应也被禁止包含任何消息体，且以消息头后的第一个空行结束。"),

    PartialContent(206, "服务器已经成功处理了部分GET请求。类似于FlashGet或者迅雷这类的HTTP下载工具都是使用此类响应实现断点续传或者将一个大文档分解为多个下载段同时下载。该请求必须包含Range头信息来指示客户端希望得到的内容范围，并且可能包含If-Range来作为请求条件。"),

    MultiStatus(207, "由WebDAV(RFC 2518)扩展的状态码，代表之后的消息体将是一个XML消息，并且可能依照之前子请求数量的不同，包含一系列独立的响应代码。"),

    AlreadyReported(208, "在DAV里面使用: propstat响应元素以避免重复枚举多个绑定的内部成员到同一个集合。"),

    IMUsed(226, "服务器已经完成了对资源的GET请求，并且响应是对当前实例应用的一个或多个实例操作结果的表示。"),

    MultipleChoice(300, "被请求的资源有一系列可供选择的回馈信息，每个都有自己特定的地址和浏览器驱动的商议信息。用户或浏览器能够自行选择一个首选的地址进行重定向。"),

    MovedPermanently(301, "被请求的资源已永久移动到新位置，并且将来任何对此资源的引用都应该使用本响应返回的若干个URI之一。如果可能，拥有链接编辑功能的客户端应当自动把请求的地址修改为从服务器反馈回来的地址。除非额外指定，否则这个响应也是可缓存的。"),

    Found(302, "请求的资源现在临时从不同的URI响应请求。由于这样的重定向是临时的，客户端应当继续向原有地址发送以后的请求。只有在Cache-Control或Expires中进行了指定的情况下，这个响应才是可缓存的。"),

    SeeOther(303, "对应当前请求的响应可以在另一个URI上被找到，而且客户端应当采用GET的方式访问那个资源。这个方法的存在主要是为了允许由脚本激活的POST请求输出重定向到一个新的资源。"),

    NotModified(304, "如果客户端发送了一个带条件的GET请求且该请求已被允许，而文档的内容 (自上次访问以来或者根据请求的条件) 并没有改变，则服务器应当返回这个状态码。304响应禁止包含消息体，因此始终以消息头后的第一个空行结尾。"),

    UseProxy(305, "被请求的资源必须通过指定的代理才能被访问。Location域中将给出指定的代理所在的URI信息，接收者需要重复发送一个单独的请求，通过这个代理才能访问相应资源。只有原始服务器才能建立305响应。"),

    TemporaryRedirect(307, "请求的资源现在临时从不同的URI响应请求。由于这样的重定向是临时的，客户端应当继续向原有地址发送以后的请求。只有在Cache-Control或Expires中进行了指定的情况下，这个响应才是可缓存的。"),

    PermanentRedirect(308, "这意味着资源现在永久位于由Location: HTTP Response标头指定的另一个URI。这与301 Moved Permanently HTTP响应代码具有相同的语义，但用户代理不能更改所使用的HTTP方法：如果在第一个请求中使用POST，则必须在第二个请求中使用POST。"),

    BadRequest(400, "语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。请求参数有误。"),

    Unauthorized(401, "当前请求需要用户验证。该响应必须包含一个适用于被请求资源的WWW-Authenticate信息头用以询问用户信息。客户端可以重复提交一个包含恰当的Authorization头信息的请求。如果当前请求已经包含了Authorization证书，那么401响应代表着服务器验证已经拒绝了那些证书。如果401响应包含了与前一个响应相同的身份验证询问，且浏览器已经至少尝试了一次验证，那么浏览器应当向用户展示响应中包含的实体信息，因为这个实体信息中可能包含了相关诊断信息。"),

    PaymentRequired(402, "此响应码保留以便将来使用，创造此响应码的最初目的是用于数字支付系统，然而现在并未使用。"),

    Forbidden(403, "服务器已经理解请求，但是拒绝执行它。与401响应不同的是，身份验证并不能提供任何帮助，而且这个请求也不应该被重复提交。如果这不是一个HEAD 请求，而且服务器希望能够讲清楚为何请求不能被执行，那么就应该在实体内描述拒绝的原因。当然服务器也可以返回一个404响应，假如它不希望让客户端获得任何信息。"),

    NotFound(404, "请求失败，请求所希望得到的资源未被在服务器上发现。没有信息能够告诉用户这个状况到底是暂时的还是永久的。假如服务器知道情况的话，应当使用410状态码来告知旧资源因为某些内部的配置机制问题，已经永久的不可用，而且没有任何可以跳转的地址。404这个状态码被广泛应用于当服务器不想揭示到底为何请求被拒绝或者没有其他适合的响应可用的情况下。"),

    MethodNotAllowed(405, "请求行中指定的请求方法不能被用于请求相应的资源。该响应必须返回一个Allow头信息用以表示出当前资源能够接受的请求方法的列表。鉴于PUT，DELETE方法会对服务器上的资源进行写操作，因而绝大部分的网页服务器都不支持或者在默认配置下不允许上述请求方法，对于此类请求均会返回405错误。"),

    NotAcceptable(406, "请求的资源的内容特性无法满足请求头中的条件，因而无法生成响应实体。"),

    ProxyAuthenticationRequired(407, "与401响应类似，只不过客户端必须在代理服务器上进行身份验证。代理服务器必须返回一个Proxy-Authenticate用以进行身份询问。客户端可以返回一个Proxy-Authorization信息头用以验证。"),

    RequestTimeout(408, "请求超时。客户端没有在服务器预备等待的时间内完成一个请求的发送。客户端可以随时再次提交这一请求而无需进行任何更改。"),

    Conflict(409, "由于和被请求的资源的当前状态之间存在冲突，请求无法完成。这个代码只允许用在这样的情况下才能被使用：用户被认为能够解决冲突，并且会重新提交新的请求。该响应应当包含足够的信息以便用户发现冲突的源头。"),

    Gone(410, "被请求的资源在服务器上已经不再可用，而且没有任何已知的转发地址。这样的状况应当被认为是永久性的。如果可能，拥有链接编辑功能的客户端应当在获得用户许可后删除所有指向这个地址的引用。如果服务器不知道或者无法确定这个状况是否是永久的，那么就应该使用404状态码。除非额外说明，否则这个响应是可缓存的。"),

    LengthRequired(411, "服务器拒绝在没有定义Content-Length头的情况下接受请求。在添加了表明请求消息体长度的有效Content-Length头之后，客户端可以再次提交该请求。"),

    PreconditionFailed(412, "服务器在验证在请求的头字段中给出先决条件时，没能满足其中的一个或多个。这个状态码允许客户端在获取资源时在请求的元信息 (请求头字段数据) 中设置先决条件，以此避免该请求方法被应用到其希望的内容以外的资源上。"),

    PayloadTooLarge(413, "服务器拒绝处理当前请求，因为该请求提交的实体数据大小超过了服务器愿意或者能够处理的范围。此种情况下，服务器可以关闭连接以免客户端继续发送此请求。如果这个状况是临时的，服务器应当返回一个Retry-After的响应头，以告知客户端可以在多少时间以后重新尝试。"),

    URITooLong(414, "请求的URI长度超过了服务器能够解释的长度，因此服务器拒绝对该请求提供服务。这比较少见，通常的情况包括：本应使用POST方法的表单提交变成了GET方法，导致查询字符 (Query String) 过长。"),

    UnsupportedMediaType(415, "对于当前请求的方法和所请求的资源，请求中提交的实体并不是服务器中所支持的格式，因此请求被拒绝。"),

    RangeNotSatisfiable(416, "如果请求中包含了Range请求头，并且Range中指定的任何数据范围都与当前资源的可用范围不重合，同时请求中又没有定义If-Range请求头，那么服务器就应当返回416状态码。"),

    ExpectationFailed(417, "此响应代码意味着服务器无法满足Expect请求标头字段指示的期望值。"),

    IAmATeapot(418, "服务器拒绝尝试用'茶壶冲泡咖啡'。"),

    MisdirectedRequest(421, "该请求针对的是无法产生响应的服务器。这可以由服务器发送，该服务器未配置为针对包含在请求URI中的方案和权限的组合产生响应。"),

    UnprocessableEntity(422, "请求格式良好，但由于语义错误而无法遵循。"),

    Locked(423, "正在访问的资源被锁定。"),

    FailedDependency(424, "由于先前的请求失败，所以此次请求失败。"),

    TooEarly(425, "服务器不愿意冒着风险去处理可能重播的请求。"),

    UpgradeRequired(426, "服务器拒绝使用当前协议执行请求，但可能在客户机升级到其他协议后愿意这样做。服务器在426响应中发送Upgrade (en-US)头以指示所需的协议。"),

    PreconditionRequired(428, "原始服务器要求该请求是有条件的。旨在防止'丢失更新'问题，即客户端获取资源状态，修改该状态并将其返回服务器，同时第三方修改服务器上的状态，从而导致冲突。"),

    TooManyRequests(429, "用户在给定的时间内发送了太多请求 ('限制请求速率')。"),

    RequestHeaderFieldsTooLarge(431, "服务器不愿意处理请求，因为它的请求头字段太大 (Request Header Fields Too Large)。请求可以在减小请求头字段的大小后重新提交。"),

    UnavailableForLegalReasons(451, "用户请求非法资源，例如：由政府审查的网页。"),

    InternalServerError(500, "服务器遇到了不知道如何处理的情况。"),

    NotImplemented(501, "此请求方法不被服务器支持且无法被处理。只有GET和HEAD是要求服务器支持的，它们必定不会返回此错误代码。"),

    BadGateway(502, "此错误响应表明服务器作为网关需要得到一个处理这个请求的响应，但是得到一个错误的响应。"),

    ServiceUnavailable(503, "服务器没有准备好处理请求。常见原因是服务器因维护或重载而停机。请注意，与此响应一起，应发送解释问题的用户友好页面。这个响应应该用于临时条件和Retry-After：如果可能的话，HTTP头应该包含恢复服务之前的估计时间。网站管理员还必须注意与此响应一起发送的与缓存相关的标头，因为这些临时条件响应通常不应被缓存。"),

    GatewayTimeout(504, "当服务器作为网关，不能及时得到响应时返回此错误代码。"),

    HTTPVersionNotSupported(505, "服务器不支持请求中所使用的HTTP协议版本。"),

    VariantAlsoNegotiates(506, "服务器有一个内部配置错误：对请求的透明内容协商导致循环引用。"),

    InsufficientStorage(507, "服务器有内部配置错误：所选的变体资源被配置为参与透明内容协商本身，因此不是协商过程中的适当端点。"),

    LoopDetected(508, "服务器在处理请求时检测到无限循环。"),

    NotExtended(510, "客户端需要对请求进一步扩展，服务器才能实现它。服务器会回复客户端发出扩展请求所需的所有信息。"),

    NetworkAuthenticationRequired(511, "511状态码指示客户端需要进行身份验证才能获得网络访问权限");

    private final Integer code;
    private final String explanation;

    Code(Integer code, String explanation) {
        this.code = code;
        this.explanation = explanation;
    }

    public Integer getCode() {
        return code;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}