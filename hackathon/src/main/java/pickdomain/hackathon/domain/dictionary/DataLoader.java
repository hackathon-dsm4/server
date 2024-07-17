package pickdomain.hackathon.domain.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pickdomain.hackathon.domain.dictionary.entity.Word;
import pickdomain.hackathon.domain.dictionary.entity.WordType;
import pickdomain.hackathon.domain.dictionary.repository.WordRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        Word word1 = Word.builder()
                .word("0.5인 가구")
                .meaning("1인 가구 중에서 2곳 이상에 거처를 두거나 여행이나 출장으로 집을 오랫동안 비우는 사람들을 일컫는 말입니다")
                .type(WordType.SOCIAL)
                .build();

        Word word2 = Word.builder()
                .word("88만원 세대")
                .meaning("비정규직 평균임금 119만원에 20대의 평균적 소득 비율 74%를 곱해 나온 88만원을 사용한 단어로, 우리나라 여러 세대 중 처음으로 승자독식 게임을 받아들인, 탈출구가 없는 세대들을 의미한다.")
                .type(WordType.SOCIAL)
                .build();

        Word word3 = Word.builder()
                .word("D-트라우마")
                .meaning("불황을 뜻하는 '디프레션(Depression)'과 정신적 외상을 의미하는 '트라우마(Trauma)'를 합친 말로서 경기침체로 인한 양극화·가정붕괴ㆍ범죄 등 사회·경제적 충격을 일컫는다.")
                .type(WordType.SOCIAL)
                .build();

        Word word4 = Word.builder()
                .word("PSD 학위")
                .meaning("Poor, Smart and Deep desire to become rich의 약자로 가난하지만 똑똑하고 부자가 되고자 하는 열망이 강한 사람을 뜻하는 말이다.")
                .type(WordType.SOCIAL)
                .build();

        Word word5 = Word.builder()
                .word("Smoking gun")
                .meaning("스모킹 건(Smoking gun)은 사전적으로 의역하자면 총을 발사하면 그 직후 연기가 피어오르는 것을 볼 수 있습니다. 이 총을 가지고 있는 사람이 범인이라고 확정 지을 수 있다는 뜻입니다. 그래서 범죄 행위로 인한 결정적인 증거로 사용되는 물건이나 사실을 나타내는 말입니다.")
                .type(WordType.SOCIAL)
                .build();

        Word word6 = Word.builder()
                .word("경험의 함정")
                .meaning("경험에 단련되어 예리해진 전문성에 가로막혀 새로운 아이디어의 잠재력을 온전히 깨닫지 못하는 것이다.")
                .type(WordType.SOCIAL)
                .build();

        Word word7 = Word.builder()
                .word("인구 고령화")
                .meaning("국제연합(UN)의 기준에 따르면 전체 인구에서 65세 이상이 차지하는 비율인 고령자 인구 비율이 7% 이상이면 고령화 사회, 14% 이상이면 고령 사회, 20% 이상이면 초고령 사회로 구분된다.")
                .type(WordType.SOCIAL)
                .build();

        Word word8 = Word.builder()
                .word("1인당 국민총소득")
                .meaning("1인당 국민소득, 국가경제규모 등을 파악하는 데 이용되는 지표로 우리나라 국민이 국내는 물론 해외에서 생산활동에 참여한 대가로 벌어들인 명목총소득을 의미하므로 명목 GDP에 명목 국외순수취요소소득을 더하여 산출힌다.")
                .type(WordType.ECONOMY)
                .build();

        Word word9 = Word.builder()
                .word("70억 법칙")
                .meaning("70의 법칙은 경제 성장, 인구 증가, 저축 증가 등을 계산할 때 복리의 효과를 이해하는 데 쓰인다. 이 법칙에 따르면 경제가 매년 x%씩 성장할 경우 경제 규모가 두 배가 되는 데 필요한 기간이 70/x년이 된다. 예를 들어 경제가 매년 1%씩 성장하면 경제 규모가 두 배가 되는 데는 70년이 걸리고, 매년 2%씩 성장하면 경제 규모가 두 배가 되는 데는 35년이 걸린다는 것이다. 이 법칙은 인구 증가와 저축 증가에도 적용된다.")
                .type(WordType.ECONOMY)
                .build();

        Word word10 = Word.builder()
                .word("BOP(Bottom of pyramid class)")
                .meaning("국가의 소득분포에서 가장 아래에 위치한 빈곤층을 지칭하는 말. 일반적으로 연간 3000달러(약 389만원) 미만의 비용으로 생활하는 이들을 BOP 계층으로 분류하는데, 이들은 전세계 인구의 70%를 차지하고 있다.")
                .type(WordType.ECONOMY)
                .build();

        Word word11 = Word.builder()
                .word("COMESA")
                .meaning("동남아프리카 공동시장 (COMESA, Common Market for Eastern and Southern Africa)은 튀니지에서 에스와티니에 이르는 21개 회원국들의 자유 무역 지대이다.")
                .type(WordType.ECONOMY)
                .build();

        Word word12 = Word.builder()
                .word("디플레이션")
                .meaning("통화량(通貨量)의 축소에 의하여 물가가 하락하고 경제 활동이 침체되는 현상. 또는, 경기 과열이나 인플레이션의 억제를 위하여 정책적으로 실시되는 통화 수축 현상이다.")
                .type(WordType.ECONOMY)
                .build();

        Word word13 = Word.builder()
                .word("인플레이션")
                .meaning("통화량이 팽창하여 화폐 가치가 폭락하며 물가가 계속적으로 등귀하여 일반 대중의 실질적 소득이 감소되는 현상. 통화 팽창")
                .type(WordType.ECONOMY)
                .build();

        Word word14 = Word.builder()
                .word("스태그플레이션")
                .meaning("경기 불황 상태에서도 물가가 계속 오르는 현상이다.")
                .type(WordType.ECONOMY)
                .build();

        Word word15 = Word.builder()
                .word("30-50클럽")
                .meaning("30-50 클럽은 1인당 국민소득 3만 달러와 인구 5천만명을 달성한 국가를 의미합니다.")
                .type(WordType.PUBLIC)
                .build();

        Word word16 = Word.builder()
                .word("3층 연금세계")
                .meaning("세계은행이 제시한 3층 연금체계는 1층이 정부가 강제 적용하는 기초연금 성격의 공적연금이고, 2층은 민간이 운용하나 강제 적용방식의 직역연금 또는 개인연금이며, 3층은 민간이 운용하는 임의적용 방식의 직역연금 또는 개인연금이다.")
                .type(WordType.PUBLIC)
                .build();

        Word word17 = Word.builder()
                .word("AEO(Authorized Economic Operator)")
                .meaning("AEO는 관세청에서 법규준수, 내부통제시스템, 재무건전성, 안전관리의 공인기준의 적정성 여부를 심사하여 공인한 우수업체를 뜻합니다.")
                .type(WordType.PUBLIC)
                .build();

        Word word18 = Word.builder()
                .word("AML(Anti Money Laundering)")
                .meaning("불법자금 세탁을 적발하고 예방하기위한 관리체계로, 금융시장의 투명성과 공정성을 확보합니다.")
                .type(WordType.PUBLIC)
                .build();

        Word word19 = Word.builder()
                .word("ASEM(Asis-Europe Meeting, 아시아-유럽 정상회의)")
                .meaning("아시아 및 유럽정상, 유럽연합(EU) 집행위원장과 아세안(ASEAN) 사무총장이 참석하여, 2년에 한 번씩 개최하는 '아시아－유럽 정상회의'를 의미합니다.")
                .type(WordType.PUBLIC)
                .build();

        Word word20 = Word.builder()
                .word("OECD")
                .meaning("경제협력개발기구는 1961년 9월 창설된 경제 부문의 국제 기구로, 주로 OECD(Organization for Economic Co-operation and Development)로 불린다.")
                .type(WordType.PUBLIC)
                .build();

        Word word21 = Word.builder()
                .word("ETL 마크")
                .meaning("ETL 인증이란 ETL Listes Mark는 미주지역의 시장진출에 도움을 주는 안전마크로서, 미국과 캐나다 전역에서 통용되어 사용되고 있습니다. 제품에 부착된 ETL Listes Mark는 제품안전 규격의 최소조건을 만족한다는 것을 의미하며, 제조자의 생산현장에서 적합성을 평가하며 주기적인 사후관리를 통해 적합성을 확인하고 있습니다.")
                .type(WordType.PUBLIC)
                .build();

        Word word22 = Word.builder()
                .word("3D TV")
                .meaning("3D TV(3-Dimensional TeleVision)는 기존의 2차원 모노영상에 깊이 정보(Depth)를 부가하여 시청자가 마치 시청각적 입체감을 느끼게 함으로써 생동감 및 현실감을 제공하는 텔레비전이다.")
                .type(WordType.SCIENCE)
                .build();

        Word word23 = Word.builder()
                .word("3G/4G")
                .meaning("3G, 4G 는 모바일 네트워크 서비스를 의미하는 단어입니다. 2G, 3G, 4G에서 G는 세대를 뜻하는 Generation 의 약자입니다. 즉, 2세대, 3세대, 4세대로 풀이할 수 있으며 세대가 올라갈수록 더 발전된 기술이라는 의미입니다.")
                .type(WordType.SCIENCE)
                .build();

        Word word24 = Word.builder()
                .word("4차 산업혁명")
                .meaning("4차 산업혁명은 물리세계, 디지털세계, 그리고 생물 세계가 융합되어, 경제와 사회의 모든 영역에 영향을 미치게 하는 새로운 산업시대를 말한다.")
                .type(WordType.SCIENCE)
                .build();

        Word word25 = Word.builder()
                .word("1차 산업혁명")
                .meaning("1차 산업혁명은 1760년~1840년 사이에 겪은 것으로 철도와 증기기관을 발명한 이후 사람의 손으로 생산하던 수공업을 기계에 의한 생산으로 바꿈으로써 생산의 수량을 늘린 일이다.")
                .type(WordType.SCIENCE)
                .build();

        Word word26 = Word.builder()
                .word("ARPU")
                .meaning("유저당 평균 매출, 일명 ARPU(Average Revenue Per User)는 일정 기간 동안 고객 한 명당 발생된 평균 수익을 의미합니다.")
                .type(WordType.SCIENCE)
                .build();

        Word word27 = Word.builder()
                .word("BCN")
                .meaning("광대역통합망이라는 뜻으로 융합된 품질 보장형 광대역 멀티미디어 서비스를 공간에 제한없이 실시간으로 이용할 수 있는 차세대 네트워크 환경이다.")
                .type(WordType.SCIENCE)
                .build();

        Word word28 = Word.builder()
                .word("CCS")
                .meaning("Carbon Capture & Storage의 약자로 이산화탄소 포집과 저장을 뜻한다. 지구온난화의 원인물질인 대량의 CO2가 대기로 배출되기 전에 고농도로 모은 후 압축 수송해 저장하는 기술이다. CCS는 CO2를 줄이기 위한 가장 이상적인 방법으로 세계적인 주목을 받고 있다.")
                .type(WordType.SCIENCE)
                .build();

        Word word29 = Word.builder()
                .word("1인 창조기업")
                .meaning("개인이 사장이면서 직원인 기업을 의미합니다. 즉, 자신이 가진 아이디어, 지식, 경험, 전문기술 등을 사업화하여 보다 창조적인 서비스를 제공하고 이윤을 창출하는 경우 1인 창조기업에 해당합니다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word30 = Word.builder()
                .word("4Ps")
                .meaning("4P란 마케팅 관련 용어로서 효과적인 마케팅 프로세스를 진행할 때 핵심적인 4가지 요소를 말한다. 4 가지 핵심 요소를 어떻게 잘 혼합하느냐에 따라 마케팅 효과를 극대화할 수 있기 때문이다. 4P는 Product, Price, Place, Promotion의 첫 글자에서 유래하였다. 이른바 ‘4P mix’로도 일컫는데 1960년대 제롬 메카시(Jerome McCarthy) 교수가 지금과 같은 형태로 정립하였다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word31 = Word.builder()
                .word("5가지 경쟁요인 분석(Five Force analysis)")
                .meaning("마이클 포터(Michael E. Porter) 교수가 제시한 “포터의 다섯 가지 힘(5 요인)” 모델은 기업이 자신들이 속한 산업의 경쟁 환경을 이해하고 전략을 수립하는 데 있어 핵심적인 이론으로 자리 잡고 있습니다. 산업 내 경쟁, 신규 진입자의 위협, 대체품의 위협, 구매자의 협상력, 공급자의 협상력의 5가지 경쟁요인 관점으로 산업 구조를 분석하고 경쟁 구도를 시각화하는 비즈니스 프레임워크입니다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word32 = Word.builder()
                .word("ABAC(APEC Business Advisory Council)")
                .meaning("ABAC 는 APEC 기업인자문위원회로 , APEC 오사카 정상회의 ('95 년 ) 합의에 의거해 1996 년 APEC 필리핀 정상회의시 설립된 민간 자문기구다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word33 = Word.builder()
                .word("ALCO 패키지")
                .meaning("ALCO는 Asset-Liability Committee의 약자로, 은행의 자산과 부채와 관련된 위험을 평가하는 위험 관리 위원회를 일컫는 말이며 ALCO 패지키란 이자율 및 수익률 곡선, 향후 프로젝트 등과 같이 기업의 비즈니스 계획 과정에 중요한 재무적 정보들을 담은 ALCO의 리포트 패키지라고 할 수 있다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word34 = Word.builder()
                .word("B2C(Business to Consumer)")
                .meaning("B2C는 'Business to Customer'의 약자로 기업과 소비자간의 거래 전체를 뜻합니다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word35 = Word.builder()
                .word("ASP(Application Service Provider)")
                .meaning("ASP(Application Service Provider)는 고가의 하드웨어, 소프트웨어를 도입하지 않고도 네트워크 인프라를 이용하여 다양한 정보화 솔루션을 사용할 수 있는 애플리케이션 임대 서비스이다.")
                .type(WordType.MANAGEMENT)
                .build();

        Word word36 = Word.builder()
                .word("2차 시장(Secondary Market)")
                .meaning("2차 시장은 처음 발행된 증권, 채권 등이 거래되는 발행시장과 구분되며, 이미 발행된 주식들의 거래가 이루어지는 유통시장을 뜻한다.")
                .type(WordType.FINANCE)
                .build();

        Word word37 = Word.builder()
                .word("5일선")
                .meaning("5일동안의 평균주가를 이어놓은 선을 의미한다")
                .type(WordType.FINANCE)
                .build();

        Word word38 = Word.builder()
                .word("ABCP(Asset Backed Commercial Paper)")
                .meaning("Asset Backed Commercial Paper의 약어로 유동화전문회사(SPC)가 매출채권, 리스채권, 회사채 등 자산을 담보로 발행하는 기업어음(CP)이다.")
                .type(WordType.FINANCE)
                .build();

        Word word39 = Word.builder()
                .word("AMA (Auto Management Account)")
                .meaning("AMA이란 고객이 설정한 조건에 따라 상대적으로 고금리를 주는 예금이나 증권사로 자동이체·관리해주는 금융상품의 한 종류이다.")
                .type(WordType.FINANCE)
                .build();

        Word word40 = Word.builder()
                .word("At The Money(ATM, 앳 더 머니)")
                .meaning("‘앳 더 머니’ 상황은 옵션의 행사가격이 기초자산의 시장 가격과 동일할 때를 가리킨다. 풋옵션과 콜옵션 모두 동시에 ‘앳 더 머니’ 상황에 처할 수 있다. ‘앳 더 머니’ 상태에서 옵션은 ‘내재 가치(intrinsic value)를 가지지 않으나, 만기일 이전까지 시간적 가치(time value)는 가진다고 볼 수 있다. 대체로 ‘앳 더 머니’ 상태에서 옵션 거래가 활발한 경향을 보인다.")
                .type(WordType.FINANCE)
                .build();

        Word word41 = Word.builder()
                .word("BIC")
                .meaning("은행 식별자 코드(Bank Identifier Code)는 은행이 금융 거래에 사용하는 국제 코드입니다. 각 은행은 자체적인 BIC를 가지고 있기 때문에 유럽 및 국제결제주문이 자동으로 정확한 은행과 지점에 도착합니다. BIC는 SWIFT 주소 또는 SWIFT 코드라고도 합니다.")
                .type(WordType.FINANCE)
                .build();

        Word word42 = Word.builder()
                .word("BIS(Bank for International Settlements)")
                .meaning("국제결제은행는 중앙은행간의 통화결제나 예금을 받아들이는 것 등을 업무로 하고 있는 은행이다.")
                .type(WordType.FINANCE)
                .build();

        wordRepository.save(word1);
        wordRepository.save(word2);
        wordRepository.save(word3);
        wordRepository.save(word4);
        wordRepository.save(word5);
        wordRepository.save(word6);
        wordRepository.save(word7);
        wordRepository.save(word8);
        wordRepository.save(word9);
        wordRepository.save(word10);
        wordRepository.save(word11);
        wordRepository.save(word12);
        wordRepository.save(word13);
        wordRepository.save(word14);
        wordRepository.save(word15);
        wordRepository.save(word16);
        wordRepository.save(word17);
        wordRepository.save(word18);
        wordRepository.save(word19);
        wordRepository.save(word20);
        wordRepository.save(word21);
        wordRepository.save(word22);
        wordRepository.save(word23);
        wordRepository.save(word24);
        wordRepository.save(word25);
        wordRepository.save(word26);
        wordRepository.save(word27);
        wordRepository.save(word28);
        wordRepository.save(word29);
        wordRepository.save(word30);
        wordRepository.save(word31);
        wordRepository.save(word32);
        wordRepository.save(word33);
        wordRepository.save(word34);
        wordRepository.save(word35);
        wordRepository.save(word36);
        wordRepository.save(word37);
        wordRepository.save(word38);
        wordRepository.save(word39);
        wordRepository.save(word40);
        wordRepository.save(word41);
        wordRepository.save(word42);
    }
}
