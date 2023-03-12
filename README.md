# elasticsearch-hanja-reading-filter
[엘라스틱서치][elasticsearch]에서 쓸 수 있는 漢字 讀音 變換 필터입니다.

[nori 分析機][analysis-nori]와 함께 쓸 수 있습니다. nori에도 `nori_readingform`이라는 필터가 內藏되어 있지만 一部分이 變換되지 않고 나오거나 正確性이 떨어지는 部分이 자주 보여 이 필터를 만들게 되었습니다.

[hanja-reading][hanja-reading] API를 백엔드로 使用합니다.

[elasticsearch]: https://github.com/elastic/elasticsearch
[hanja-reading]: https://github.com/Lee0701/hanja-reading
[analysis-nori]: https://github.com/elastic/elasticsearch/tree/main/plugins/analysis-nori
