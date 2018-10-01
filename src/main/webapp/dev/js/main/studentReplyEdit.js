import {
    showModalConfirmation,
} from '../common/bootboxWrapper';

import {
    ParamsNames,
    BootstrapContextualColors,
} from '../common/const';

import {
    scrollToElement,
} from '../common/scrollTo';

function editReply() {
    $('#btnSaveReply').show();
    $('.toggle_inputs_').prop('disabled', false);
    $('#btnEditReply').hide();
}

$(document).ready(() => {
  $('#btnEditReply').click(editReply);
});
