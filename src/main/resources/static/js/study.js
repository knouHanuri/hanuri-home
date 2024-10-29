/* 스터디 조회 */
function edit(studyId){
    window.location.href = `/study/form?studyId=${studyId}`;
}

function del(studyId) {
    if (confirm('스터디를 삭제하시겠습니까?')) {
        let msg = "다시 시도해주세요.";
        fetch(`/study/delete/${studyId}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) msg = "스터디가 삭제되었습니다.";
        })
        .catch(error => {
            console.error("삭제 중 오류 발생:", error);
        })
        .finally(() => {
            alert(msg);
            // 무조건 페이지 리로드
            location.reload();
        });
    }
}

/* 스터디 입력 */
const inputs = {
    title: document.getElementById('title'),
    status: document.getElementById('status'),
    schedule: document.getElementById('schedule'),
    startDate: document.getElementById('startDate'),
    endDate: document.getElementById('endDate')
};

inputs['startDate'].addEventListener('change', function () {
    inputs['endDate'].min = inputs['startDate'].value; // 시작 날짜를 종료 날짜의 최소값으로 설정
});

inputs['endDate'].addEventListener('change', function () {
    inputs['startDate'].max = inputs['endDate'].value; // 종료 날짜를 시작 날짜의 최대값으로 설정
});

document.getElementById('studyForm').addEventListener('submit', function (event) {
    // 기본 제출 방지
    event.preventDefault();

    let nullCnt = 0;

    for (let input of Object.entries(inputs)) {
        if (!input[1].value.trim()) {
            alert(document.querySelector(`label[for="${input[0]}"]`).textContent + '은/는 필수 입력입니다.');
            input[1].focus();
            nullCnt++;
            return false;
        }
    }

    if (nullCnt === 0) {
        if (confirm(`스터디를 ${document.getElementById('submitBtn').textContent}하시겠습니까?`)) {
            this.method = 'post';
            this.action = '/study/formSave';
            this.submit();
        }
    }
});
