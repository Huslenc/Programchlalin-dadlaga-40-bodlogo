Рон Гермиона хоёр хориотой ойн гүнд эмийн орц цуглуулж байгаа бөгөөд тэд замаа алдаж чадлаа. Ойгоос гарах зам хаагдсан тул тэднийг Хогвартс руу буцаах портын түлхүүр рүү явах ёстой.

Ойг NxM сүлжээ гэж үзье. Нүд бүр хоосон (.-ээр төлөөлдөг) эсвэл модоор (X-ээр төлөөлдөг) хаагдсан байна. Рон, Гермиона хоёр хоосон нүднүүдийн дундуур ЗҮҮН, БАРУУН, ДЭЭШ, ДООШ (нэг үүр дотор хамтдаа) хөдөлж чаддаг ч модны нүдээр дамжин явж чадахгүй. Тэдний эхлэлийн нүдийг M тэмдэгтээр, порт товчлууртай нүдийг тэмдэгтээр тэмдэглэсэн байна. Зүүн дээд буланг (0,0) гэж индексжүүлсэн.

.X.X......X

.X*.X.XXX.X

.XX.X.XM...

......ХХХХ.

Дээрх жишээнд Рон, Гермиона нар (2,7) индекс, порт түлхүүр нь (1,2) дээр байрладаг. Нүд бүрийг матрицын конвенцийн дагуу индексжүүлдэг.

Гермиона түлхүүрээ олоод явах цаг болсон гэж шийдэв. Тэд зам дагуу эхэлж, чиглэлээ сонгох бүртээ, тэр саваагаа даллахад энэ нь зөв чиглэлийг зааж байна. Рон саваагаа яг К удаа даллах хэрэгтэй болно гэж бооцоо тавьж байна. Та Роны таамаг зөв эсэхийг тодорхойлж чадах уу?

Дээрх газрын зургийг M нь эхлэлийн цэг болох цуваа байдлаар харуулсан замыг дахин зурсан (энэ тохиолдолд шийдвэр байхгүй), 1 нь шийдвэр гаргах цэгийг зааж, 0 нь зам дээрх алхам юм.

.X.X.10000X

.X*0X0XXX0X

.XX0X0XM01.

...100XXXX.

Гермиона саваагаа ашиглах ёстой гурван тохиолдол байдаг.

Тайлбар: Эхлэх байршлаас портын товчлуур хүртэлх ганц зам байх нь баталгаатай.

Функцийн тодорхойлолт

Доорх засварлагчийн countLuck функцийг гүйцээнэ үү. Энэ нь Роны зөв эсвэл буруу бол мөрийг буцаах ёстой.

countLuck нь дараах параметрүүдийг агуулна.

матриц: мөрүүдийн жагсаалт, тус бүр нь матрицын мөрийг төлөөлдөг k: Роны таамаглалыг илэрхийлэх бүхэл тоо Оролтын формат

Эхний мөрөнд туршилтын тохиолдлын тоо t бүхэл тоо байна. Туршилтын тохиолдол бүрийг дараах байдлаар тайлбарлав. Эхний мөрөнд зайгаар тусгаарлагдсан 2 бүхэл тоо n ба m, ойн матрицын мөр, баганын тоог агуулна. Дараагийн мөр бүр нь ойн матрицын мөрийг дүрсэлсэн m урттай мөрийг агуулна. Сүүлийн мөрөнд Гермиона саваагаа хэдэн удаа даллахыг Роны таамагласан бүхэл k тоо байна.

Хязгаарлалт

1=<t=<10

1=<n,m=<100

0=<k=<10000

Ойд яг нэг М, нэг байх болно. М ба хоёрын хооронд яг нэг зам бий.
https://www.hackerrank.com/challenges/count-luck/problem?isFullScreen=true
